package com.iuicity.databindingdemo.orderconverter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.iuicity.databindingdemo.R;
import com.iuicity.databindingdemo.databinding.ActivityOrderConverterBinding;

/**
 * Created by Shui on 2017/12/27.
 */

public class OrderConverterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityOrderConverterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_order_converter);
        binding.setOrderTypeCode(AppConstants.ORDER_TYPE_1);
    }
}
