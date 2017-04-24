package com.deity.raillery.model.entity;

/**
 * 动态信息
 * Created by Deity on 2017/4/24.
 */

public class DynamicEntity {
    /**动态信息描述*/
    private String description;
    /**文件路径*/
    private String mFileUrl;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getmFileUrl() {
        return mFileUrl;
    }

    public void setmFileUrl(String mFileUrl) {
        this.mFileUrl = mFileUrl;
    }
}
