package com.iuicity.databindingdemo.orderconverter;

import android.databinding.InverseMethod;


/**
 * Created by Shui on 2017/12/27.
 */

public class DataConvert {
    @InverseMethod("orderTypeToString")
    public static String stringToOrderType(String value) {
        if (value == null) {
            return null;
        }
        switch (value) {
            case "立即单":
                return AppConstants.ORDER_TYPE_1;
            case "预约单":
                return AppConstants.ORDER_TYPE_2;
            case "接机单":
                return AppConstants.ORDER_TYPE_3;
            case "送机单":
                return AppConstants.ORDER_TYPE_4;
            case "半日租单":
                return AppConstants.ORDER_TYPE_5;
            case "全日租单":
                return AppConstants.ORDER_TYPE_6;
            default:
                return null;
        }
    }


    public static String orderTypeToString(String code) {
        if (code == null) {
            return null;
        }
        switch (code) {
            case AppConstants.ORDER_TYPE_1:
                return "立即单";
            case AppConstants.ORDER_TYPE_2:
                return "预约单";
            case AppConstants.ORDER_TYPE_3:
                return "接机单";
            case AppConstants.ORDER_TYPE_4:
                return "送机单";
            case AppConstants.ORDER_TYPE_5:
                return "半日租单";
            case AppConstants.ORDER_TYPE_6:
                return "全日租单";
            default:
                return null;
        }
    }
}
