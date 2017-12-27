package com.iuicity.databindingdemo;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseMethod;
import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;

import com.iuicity.databindingdemo.customerattr.CustomerView;

/**
 * view的扩展方法
 * Created by Shui on 2017/12/26.
 */

public class ViewExt {
    @BindingAdapter({"isShowStrikeThrough"})
    public static void showStrikeThrough(TextView txtView, boolean isShowStrikeThrough) {
        if (isShowStrikeThrough) {
            Paint paint = txtView.getPaint();
            paint.setAntiAlias(true);
            paint.setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

    @BindingAdapter({"android:visibility"})
    public static void setCustomerVisibility(TextView txtView, boolean isShowStrikeThrough) {
        txtView.setVisibility(isShowStrikeThrough ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("display")
    public static void setDisplay(CustomerView view, boolean isDisplay) {
        view.setVisibility(isDisplay ? View.VISIBLE : View.GONE);
    }

    @InverseBindingAdapter(attribute = "display", event = "displayAttrChanged")
    public static boolean isDisplay(CustomerView view) {
        return view.getVisibility() == View.VISIBLE;
    }

    @BindingAdapter(value = "displayAttrChanged")
    public static void setChangeListener(CustomerView view, final InverseBindingListener listener) {
        view.setVisibilityChangeListener(new CustomerView.OnVisibilityChangeListener() {
            @Override
            public void onChange(int visibility) {
                listener.onChange();
            }
        });
    }




//    @BindingAdapter({"android:text"})
//    public static void setText(TextView textView, CharSequence text) {
//        if (TextUtils.equals(textView.getText(), text)) {
//            return;
//        }
//        textView.setText(TextUtils.isEmpty(text) ? "" : text);
//    }
}
