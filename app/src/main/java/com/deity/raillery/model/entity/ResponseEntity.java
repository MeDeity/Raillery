package com.deity.raillery.model.entity;

/**
 * 动态信息
 * Created by Deity on 2017/4/24.
 */

public class ResponseEntity {
    /**动态信息描述*/
    private String message;
    /**文件路径*/
    private int status;

    private DynamicEntity[] data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DynamicEntity[] getData() {
        return data;
    }

    public void setData(DynamicEntity[] data) {
        this.data = data;
    }
}
