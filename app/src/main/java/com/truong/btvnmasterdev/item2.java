package com.truong.btvnmasterdev;

import android.os.Parcel;
import android.os.Parcelable;

public class item2 implements Parcelable {
    public final String name;

    public item2(String name) {
        this.name = name;
    }

    protected item2(Parcel in) {
        name = in.readString();
    }

    public static final Creator<item2> CREATOR = new Creator<item2>() {
        @Override
        public item2 createFromParcel(Parcel in) {
            return new item2(in);
        }

        @Override
        public item2[] newArray(int size) {
            return new item2[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
