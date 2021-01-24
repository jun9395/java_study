package com.ssafy.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {

    int number;
    String message;

    public SimpleData(int num, String msg) {
        number = num;
        message = msg;
    }

    // Parcel 객체에서 읽기
    public SimpleData(Parcel src) {
        number = src.readInt();
        message = src.readString();
    }

    // CREATOR 상수 정의의
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public SimpleData createFromParcel(Parcel in) {
            // SimpleData 생성자를 호출해 Parcel 객체에서 읽기
            return new SimpleData(in);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };


    public int describeContents() {
        return 0;
    }

    // Parcel 객체로 쓰기
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
