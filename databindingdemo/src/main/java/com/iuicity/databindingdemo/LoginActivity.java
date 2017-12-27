package com.iuicity.databindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.iuicity.databindingdemo.databinding.ActivityLoginBinding;

/**
 * Created by Shui on 2017/12/27.
 */

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        final LoginModel loginModel = new LoginModel();
        loginModel.setPhone("15618359121");
        binding.setLoginModel(loginModel);
        binding.setLoginControler(new LoginControler(loginModel));
        loginModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Log.d("LoginActivity", "haha");
            }
        });
        binding.btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LoginActivity", "model里面的电话号码是：" + loginModel.toString());
            }
        });
    }
}
