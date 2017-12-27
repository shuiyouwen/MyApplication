package com.iuicity.databindingdemo.customerattr;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.iuicity.databindingdemo.R;
import com.iuicity.databindingdemo.databinding.ActivityCustomerAttrBinding;

/**
 * 自定义双向绑定属性
 * Created by Shui on 2017/12/27.
 */

public class CustomerAttrActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityCustomerAttrBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_customer_attr);
        final ObservableBoolean data = new ObservableBoolean();
        data.set(true);
        binding.setDisplay(data);

        binding.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.set(false);
            }
        });
    }
}
