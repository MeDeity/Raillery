package com.deity.raillery.data;

import android.app.Application;

/**
 * Created by fengwenhua on 2017/4/26.
 */

public class RailleryApplication extends Application {

    public static RailleryApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
