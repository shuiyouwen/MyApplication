package com.iuicity.databindingdemo;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

/**
 * Created by Shui on 2017/12/26.
 */

public class MainHandler {

    private final User mUser;

    public MainHandler(User user) {
        mUser = user;
    }

    public void onCheckChange(CompoundButton button, boolean checked) {
//        mUser.setName(checked ? "选中了" : "没选中");
//        Toast.makeText(button.getContext(), "选择了，哈哈哈", Toast.LENGTH_SHORT).show();
        Toast.makeText(button.getContext(), mUser.getName(), Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        mUser.setName("哈哈点击了，应该要改变哦");
    }
}
