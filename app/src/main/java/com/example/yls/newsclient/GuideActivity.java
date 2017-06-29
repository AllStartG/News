package com.example.yls.newsclient;

import android.animation.Animator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GuideActivity extends BaseActivity {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_guide;
    }


    private Button btnStart;
    private ImageView iv01;
    private boolean mExitActivity = false;
    private int index = 0;
    private int[] imageRes = new int[]{
            R.drawable.ad_new_version1_img1,
            R.drawable.ad_new_version1_img2,
            R.drawable.ad_new_version1_img3,
            R.drawable.ad_new_version1_img4,
            R.drawable.ad_new_version1_img5,
            R.drawable.ad_new_version1_img6,
            R.drawable.ad_new_version1_img7,
    };

    private MediaPlayer mMediaPlayer;

    @Override
    public void initView() {
        btnStart = (Button) findViewById(R.id.btn_start);
        iv01 = (ImageView) findViewById(R.id.iv_01);


    }

    @Override
    public void initListener() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterMainActivity();
            }
        });
    }

    @Override
    public void initData() {
        startAnimation(); //开始显示动画
        playBackgroundMusic();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mExitActivity = true;
    }

    private void startAnimation() {

        int indexId = imageRes[index % imageRes.length];
        iv01.setBackgroundResource(indexId);
        index++;
        iv01.setScaleX(1.0f);
        iv01.setScaleY(1.0f);

        iv01.animate()
                .scaleX(1.2f)
                .scaleY(1.2f)
                .setDuration(3500)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (!mExitActivity) {
                            startAnimation();
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();
    }

    private void playBackgroundMusic() {

        mMediaPlayer = new MediaPlayer();
        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.new_version);

        mMediaPlayer.setLooping(true);  //循环播放
        mMediaPlayer.setVolume(1.0f, 1.0f);  //左右声道音量
//            mMediaPlayer.prepare();  //缓冲文件,raw文件夹下不需缓存，asset下需要
        mMediaPlayer.start();   //开始播放

    }

    /**
     * Acitvity界面显示时调用
     */
    @Override
    protected void onStart() {
        super.onStart();
        //开始播放
        playBackgroundMusic();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //释放MediaPlayer
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    /**
     * Activity界面退出时调用
     */


    private void enterMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
