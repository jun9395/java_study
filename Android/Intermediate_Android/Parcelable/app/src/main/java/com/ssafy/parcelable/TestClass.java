package com.ssafy.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class TestClass implements Parcelable {
    int data10;
    String data20;


    // 안드로이드 OS에서는
    // 새롭게 실행된 액티비티에서 객체를 복원하는 작업을 할 때 Creator를 사용한다.
    // 이 변수에서 createFromParcel이라는 메서드를 호출하여
    // 반환하는 객체들을 받아서 사용한다.
    public static final Creator<TestClass> CREATOR = new Creator<TestClass>() {
        @Override
        public TestClass createFromParcel(Parcel source) {
            TestClass t1 = new TestClass();

            // 36번째 줄에서 이동 -> Int, String 순서대로 뽑아야 한다
            t1.data10 = source.readInt();
            t1.data20 = source.readString();

            return t1;
        }

        @Override
        public TestClass[] newArray(int size) {
            return new TestClass[size];    // 배열로 추출할 때 사용하는 부분
        }
    };


    // 첫 번째 액티비티에서 객체를 Intent에 집어넣을 때 호출됨
   @Override
    public void writeToParcel(Parcel dest, int flags) {
        // 처음에 Int 집어넣고 두번째로 String 집어넣었으므로 -> 20번째 줄로 이동
        dest.writeInt(data10);
        dest.writeString(data20);
    }


    @Override
    public int describeContents() {
        return 0;
    }
}
