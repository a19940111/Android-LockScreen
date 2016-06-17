package com.heqiang.lockscreen.Modules;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by zhengchengbo on 2016/5/24.
 */
public class DeviceManagerBC extends DeviceAdminReceiver {
    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
        Toast.makeText(context,"已经注册成系统组件", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDisabled(Context context, Intent intent) {
        super.onDisabled(context, intent);
        Toast.makeText(context,"注销了系统组件", Toast.LENGTH_SHORT).show();
    }
}
