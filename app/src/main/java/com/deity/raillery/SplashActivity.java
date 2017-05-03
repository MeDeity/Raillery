package com.deity.raillery;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.deity.raillery.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by fengwenhua on 2017/4/27.
 */

public class SplashActivity extends BaseActivity {
    @BindView(R.id.splash_resouce)
    public ImageView splash_resouce;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startAnimation();
    }

    private void startAnimation(){
        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.activity_splash);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent mainIntent = new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(mainIntent);
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        splash_resouce.startAnimation(animation);
    }



    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }
}
