package com.heqiang.lockscreen.Contorller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.heqiang.lockscreen.Modules.DeviceManagerBC;
import com.heqiang.lockscreen.Modules.LockScreen;
import com.heqiang.lockscreen.R;

public class SecondMainActivity extends AppCompatActivity {
    private Button btn_lockScreen;
    private LockScreen lockScreen;
    private LockScreen.JudgeLockScreenAdmin judge;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);
        initWiget();
        initModulesClass();
        initSystemNativeClass();
        setWigetLisener();


    }

    private void initWiget() {
        btn_lockScreen = (Button) findViewById(R.id.btn_SecondMainActivity_LockScreen);
    }

    private void setWigetLisener() {
        btn_lockScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (judge.judgeIsOrNot()) {
                    lockScreen.lockScreen();
                } else {
                    intent.setClass(SecondMainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void initModulesClass() {
        lockScreen = new LockScreen(this);
        judge = lockScreen.new JudgeLockScreenAdmin();
    }

    public void initSystemNativeClass() {
        intent = new Intent();
    }
}
