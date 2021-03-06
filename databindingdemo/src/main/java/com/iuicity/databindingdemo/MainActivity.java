package com.iuicity.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.iuicity.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User();
        user.setName("水水");
        user.setAge(19);
        binding.setUser(user);
        binding.setHandler(new MainHandler(user));
//        binding.setOrderTypeCode("ORDER_TYPE_1");
    }
}
