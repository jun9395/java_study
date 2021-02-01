package com.ssafy.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    TextView text1;

    // ViewPager를 통해서 보여줄 View 객체를 갖고 있는 ArrayList
    ArrayList<View> viewList = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        text1 = (TextView)findViewById(R.id.textView);

        // View 객체를 생성하여 ArrayList에 담는다
        // LayoutInflater는 xml 파일로 View 객체를 만들 때 사용하는 클래스
        LayoutInflater inflater = getLayoutInflater();
        View v1 = inflater.inflate(R.layout.view1, null);
        View v2 = inflater.inflate(R.layout.view2, null);
        View v3 = inflater.inflate(R.layout.view3, null);

        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);


        // 이제 Pager를 구성하기 위해 사용할 Adapter 생성 (밑으로 내려감)


        CustomAdapter customAdapter = new CustomAdapter();
        pager.setAdapter(customAdapter);
    }


    // 방금 만든 레이아웃을 반환하는 Fragment 클래스
    class SlidePageFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }


    class CustomAdapter extends RecyclerView.Adapter {
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        // 뷰 페이저를 통해 보여줄 항목의 개수
        public int getItemCount() {
            return viewList.size();
        }
    }


//    class CustomAdapter extends PagerAdapter {
//        @Override
//        // 뷰 페이저를 통해 보여줄 항목의 개수
//        public int getCount() {
//            return viewList.size();
//        }
//
//        // 뷰 페이저를 통해 보여줄 뷰 객체를 반환
//        @NonNull
//        @Override
//        // 현재 보여줄 View를 세팅할 때 이 메서드가 호출됨
//        // 반환한 뷰 객체와 페이저에 세팅한 뷰 객체가 같은 경우에만 보여줄 수 있도록(isViewFromObject)
//        public Object instantiateItem(@NonNull ViewGroup container, int position) {
//            // position번 째 뷰 객체를 뷰 페이저에 세팅
//            pager.addView(viewList.get(position));
//            // 페이저에 뷰 객체 세팅 + 뷰 반환까지
//            return viewList.get(position);
//        }
//
//        @Override
//        // instantiateItem 메서드에서 반환한 뷰 객체를 사용할 것인지 boolean 값을 반환
//        // 세팅한 뷰 객체와 반환한 뷰 객체가 isViewFromObject에 매개변수로 들어온다
//        // 안드로이드OS 자기 필요에 의해서 이 메서드를 다른 용도로도 사용한다
//        // 그래서 이 메서드를 사용해준다
//        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//            // viewpager에 의해서 세팅된 화면 객체와 반환된 object 개체가 같은 경우에만 반환해서 보여주라고 하기
//            return view == object;
//        }
//
//
//        @Override
//        // 뷰가 제거될 때 호출
//        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            pager.removeView((View)object);
//        }
//    }
}