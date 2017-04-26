package com.deity.raillery.utils;


import com.deity.raillery.data.RailleryApplication;

/**
 * Created by Deity on 2016/12/3.
 */

public class I18NData {
    /**获取颜色*/
    public static int getColor(int id){
        return RailleryApplication.instance.getResources().getColor(id);
    }
}
