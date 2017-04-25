package com.deity.raillery.utils;

import android.util.Log;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 通过参数类型自动创建类工具
 * Created by Deity on 2017/4/25.
 */

public class ClazzUtils {

    public static <T> T getGenericInstance(Object object){
        Type classType = ((ParameterizedType)object.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            return ((Class<T>)classType).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            Log.i(ClazzUtils.class.getSimpleName(),"getGenericInstance exception"+e.getMessage());
        }
        return null;
    }
}
