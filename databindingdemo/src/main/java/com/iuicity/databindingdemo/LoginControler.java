package com.iuicity.databindingdemo;

import android.util.Log;
import android.view.View;

/**
 * Created by Shui on 2017/12/27.
 */

public class LoginControler {

    private final LoginModel mLoginModel;

    public LoginControler(LoginModel loginModel) {
        mLoginModel = loginModel;
    }

    public void oClick(View view) {
        Log.d("LoginControler", "查看登录参数:" + mLoginModel.toString());
    }
}
