package com.heqiang.lockscreen.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.heqiang.lockscreen.Modules.LockScreen;
import com.heqiang.lockscreen.R;

/**
 * Created by zhengchengbo on 2016/5/26.
 */
public class CancelLockScreenAdmin extends Fragment {
    private View view;
    private Button btn_cancelDeviceLockAdmin, btn_lockScreen;
    private LockScreen lockScreen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cancel_lock_screen_admin, null);
        initWiget();
        initModulesClass();
        setWidgetListener();
        return view;
    }


    public void initWiget() {
        btn_cancelDeviceLockAdmin = (Button) view.findViewById(R.id.btn_cancelDeviceLockAdmin);
        btn_lockScreen = (Button) view.findViewById(R.id.btn_LockScreen);
    }

    public void setWidgetListener() {
        btn_cancelDeviceLockAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lockScreen.cancelLockScreen();
                getFragmentManager().beginTransaction().replace(R.id.Container, new GetLockScreenAdmin()).commit();
            }
        });
        btn_lockScreen.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                lockScreen.lockScreen();
            }
        });
    }

    public void initModulesClass() {
        lockScreen = new LockScreen(getActivity());
    }
}
