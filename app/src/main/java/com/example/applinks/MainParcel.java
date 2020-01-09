package com.example.applinks;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import static android.os.UserHandle.readFromParcel;


class MainParcel implements Parcelable {
    private List<String> list_1;
    private List<String> list_2;
    private String string1="";
    private String string2="";
    public static final Parcelable.Creator<MainParcel> CREATOR
            = new Parcelable.Creator<MainParcel>() {
        public MainParcel createFromParcel(Parcel in) {
            return new MainParcel(in);
        }




        public MainParcel[] newArray(int size) {
            return new MainParcel[size];
        }
    };


    public MainParcel() {

    }
    public List<String> getList_1() {
        return list_1;
    }

    public void setList_1(List<String> list_1) {
        this.list_1 = list_1;
    }

    public List<String> getList_2() {
        return list_2;
    }

    public void setList_2(List<String> list_2) {
        this.list_2 = list_2;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public MainParcel(Parcel in) {
        readFromParcel(in);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(list_1);
        dest.writeStringList(list_2);
    }

}