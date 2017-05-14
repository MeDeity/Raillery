package com.deity.raillery.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * 工具集合
 * Created by Deity on 2017/5/15.
 */

public class AppUtils {

    public static DisplayMetrics getScreenPixels(Context context){
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        return dm;
    }
}
