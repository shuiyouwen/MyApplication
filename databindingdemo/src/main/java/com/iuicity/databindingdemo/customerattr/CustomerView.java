package com.iuicity.databindingdemo.customerattr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 简单的一个自定义view
 * Created by Shui on 2017/12/27.
 */

public class CustomerView extends View {
    public CustomerView(Context context) {
        super(context);
    }

    public CustomerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private OnVisibilityChangeListener mListener;

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (mListener != null) {
            mListener.onChange(visibility);
        }
    }

    public void setVisibilityChangeListener(OnVisibilityChangeListener listener) {
        mListener = listener;
    }

    public interface OnVisibilityChangeListener {
        void onChange(int visibility);
    }
}
