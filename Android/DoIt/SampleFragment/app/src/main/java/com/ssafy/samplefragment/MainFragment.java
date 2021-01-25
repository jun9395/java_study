package com.ssafy.samplefragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link MainFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class MainFragment extends Fragment {
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public MainFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment MainFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static MainFragment newInstance(String param1, String param2) {
//        MainFragment fragment = new MainFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_main, container, false);
        
        // 메인 프래그먼트 안에 표시되는 최상위 레이아웃은 인플레이션을 통해 참조한 rootView 객체
        // 최상위 레이아웃(rootView)은 메인 프래그먼트 안에 들어있는 것이고
        // 메인 프래그먼트는 이 레이아웃을 화면에 보여주기 위한 틀
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main, container, false);
        
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 프래그먼트에서는 getActivity() 메서드를 호출하면 프래그먼트가 올라가있는
                // 액티비티가 어떤 것인이 확인 가능
                MainActivity activity = (MainActivity)getActivity();
                // 프래그먼트 매니저를 이용해 프래그먼트를 전환하는 메서드
                // 프래그먼트 관리를 액티비티가 하기 때문에
                // 액티비티에서 프래그먼트를 전환하도록 만들어야 하므로 이런 구조
                // 즉, 하나의 프래그먼트에서 다른 프래그먼트를 직접 띄우지 않고
                // 액티비티를 통해서 다른 프래그먼트를 띄우도록 해야 한다
                activity.onFragmentChanged(0);
            }
        });

        return rootView;
    }
}