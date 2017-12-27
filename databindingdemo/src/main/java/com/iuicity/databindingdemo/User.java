package com.iuicity.databindingdemo;

import android.databinding.BaseObservable;

/**
 * Created by Shui on 2017/12/26.
 */

public class User extends BaseObservable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.user);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.user);
    }
}
