package com.heqiang.lockscreen.Fragment;


import android.app.Fragment;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.heqiang.lockscreen.Modules.DeviceManagerBC;
import com.heqiang.lockscreen.Modules.LockScreen;
import com.heqiang.lockscreen.R;

public class GetLockScreenAdmin extends Fragment {
    private View view;
    private Button button;
    private LockScreen lockScreen;
    private LockScreen.JudgeLockScreenAdmin judge;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_get_lock_screen_admin, null);
        initWidget();
        initModulesClass();
        setWidgetListener();
        return view;
    }

    public void initWidget() {
        button = (Button) view.findViewById(R.id.btn_getLockDeviceAdmin);
    }

    public void initModulesClass() {
        lockScreen = new LockScreen(getActivity());
        judge = lockScreen.new JudgeLockScreenAdmin();
    }

    public void setWidgetListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                ComponentName componentName = new ComponentName(getActivity(), DeviceManagerBC.class);
                intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
                startActivity(intent);
                if (judge.judgeIsOrNot()) {
                    getFragmentManager().beginTransaction().replace(R.id.Container, new CancelLockScreenAdmin()).commit();
                }
            }
        });
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);

    }
}
