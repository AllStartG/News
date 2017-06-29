package com.example.yls.newsclient;

import android.content.Intent;
import android.os.SystemClock;

public class StartActivity extends BaseActivity {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_start;
    }

    @Override
    public void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1500);
                enterGuideActivity();
            }
        }).start();
    }

    private void enterGuideActivity() {
        Intent intent = new Intent(this, GuideActivity.class);
        startActivity(intent);
        finish();   //销毁引导页
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView() {

    }
}
