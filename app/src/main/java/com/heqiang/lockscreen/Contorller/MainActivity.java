package com.heqiang.lockscreen.Contorller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.heqiang.lockscreen.Fragment.CancelLockScreenAdmin;
import com.heqiang.lockscreen.Fragment.GetLockScreenAdmin;
import com.heqiang.lockscreen.Modules.LockScreen;
import com.heqiang.lockscreen.R;

public class MainActivity extends AppCompatActivity {

    private LockScreen lockSrceen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lockSrceen=new LockScreen(this);
        LockScreen.JudgeLockScreenAdmin judge=lockSrceen.new JudgeLockScreenAdmin();
        if(judge.judgeIsOrNot()){
            getFragmentManager().beginTransaction().add(R.id.Container,new CancelLockScreenAdmin()).commit();
        }else{
            getFragmentManager().beginTransaction().add(R.id.Container,new GetLockScreenAdmin()).commit();
        }
    }
}
