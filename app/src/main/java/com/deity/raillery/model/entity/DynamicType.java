package com.deity.raillery.model.entity;

/**
 * 动态内容类型
 * Created by Deity on 2017/5/22.
 */

public enum  DynamicType {
    TODAY(1),HOT(2);
    private int code;

    DynamicType(int code){
        this.code = code;
    }

    public static DynamicType whichOne(int postion){
        for (DynamicType type:DynamicType.values()){
            if (type.code==postion){
                return type;
            }
        }
        return TODAY;
    }


}
