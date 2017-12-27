package com.iuicity.myapplication;

import android.content.Context;

/**
 * 工具类
 * Created by Shui on 2017/9/6.
 */

public class Utils {


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
