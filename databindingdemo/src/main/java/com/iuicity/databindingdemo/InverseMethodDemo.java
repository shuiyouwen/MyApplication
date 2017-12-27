package com.iuicity.databindingdemo;

import android.databinding.InverseMethod;
import android.text.TextUtils;

/**
 * Created by Shui on 2017/12/26.
 */

public class InverseMethodDemo {
    private static final String ORDER_TYPE_1 = "ORDER_TYPE_1";
    private static final String ORDER_TYPE_2 = "ORDER_TYPE_2";
    private static final String ORDER_TYPE_3 = "ORDER_TYPE_3";
    private static final String ORDER_TYPE_4 = "ORDER_TYPE_4";
    private static final String ORDER_TYPE_5 = "ORDER_TYPE_5";
    private static final String ORDER_TYPE_6 = "ORDER_TYPE_6";


    public static String stringToOrderType(String value) {
        if (value == null) {
            return null;
        }
        switch (value) {
            case "立即单":
                return ORDER_TYPE_1;
            case "预约单":
                return ORDER_TYPE_2;
            case "接机单":
                return ORDER_TYPE_3;
            case "送机单":
                return ORDER_TYPE_4;
            case "半日租单":
                return ORDER_TYPE_5;
            case "全日租单":
                return ORDER_TYPE_6;
            default:
                return null;
        }
    }


    @InverseMethod("orderTypeToString")
    public static String orderTypeToString(String code) {
        if (TextUtils.isEmpty(code)) {
            return null;
        }
        switch (code) {
            case ORDER_TYPE_1:
                return "立即单";
            case ORDER_TYPE_2:
                return "预约单";
            case ORDER_TYPE_3:
                return "接机单";
            case ORDER_TYPE_4:
                return "送机单";
            case ORDER_TYPE_5:
                return "半日租单";
            case ORDER_TYPE_6:
                return "全日租单";
            default:
                return null;
        }
    }
}
