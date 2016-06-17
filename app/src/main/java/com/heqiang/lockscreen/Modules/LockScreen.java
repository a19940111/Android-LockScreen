package com.heqiang.lockscreen.Modules;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;

/**
 * Created by zhengchengbo on 2016/5/26.
 */
public class LockScreen {
    private DevicePolicyManager devicePolicyManager;
    private ComponentName componentName;

    public LockScreen(Context context) {
        devicePolicyManager = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        componentName = new ComponentName(context, DeviceManagerBC.class);
    }

    public void lockScreen() {
        devicePolicyManager.lockNow();
    }

    public void cancelLockScreen() {
        devicePolicyManager.removeActiveAdmin(componentName);

    }

    public class JudgeLockScreenAdmin {
        public boolean judgeIsOrNot() {
            if (devicePolicyManager.isAdminActive(componentName)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
