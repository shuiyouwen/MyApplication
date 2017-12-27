package com.iuicity.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import static android.text.TextUtils.isEmpty;

/**
 * Created by Shui on 2017/12/27.
 */

public class LoginModel extends BaseObservable {
    private String phone;
    private String password;
    private boolean check;
    private boolean canLogin;//是否可以登录的状态

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (!TextUtils.equals(this.phone, phone)) {
            this.phone = phone;
            canLogin = canLogin();
            notifyPropertyChanged(BR.phone);
            notifyPropertyChanged(BR.canLogin);
        }
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!TextUtils.equals(this.password, password)) {
            this.password = password;
            canLogin = canLogin();
            notifyPropertyChanged(BR.password);
            notifyPropertyChanged(BR.canLogin);
        }
    }

    @Bindable
    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        if (this.check != check) {
            this.check = check;
            canLogin = canLogin();
            notifyPropertyChanged(BR.check);
            notifyPropertyChanged(BR.canLogin);
        }
    }

    @Bindable
    public boolean isCanLogin() {
        return canLogin;
    }

    /**
     * 是否可点击
     *
     * @return
     */
    public boolean canLogin() {
        return !(isEmpty(phone) || isEmpty(password) || !check || phone.length() < 5);
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", check=" + check +
                '}';
    }
}
