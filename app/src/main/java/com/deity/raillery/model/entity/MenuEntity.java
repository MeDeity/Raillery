package com.deity.raillery.model.entity;

/**
 * 菜单信息
 * Created by Deity on 2017/5/17.
 */

public class MenuEntity {
    /**编号*/
    private int menuId;
    /**描述*/
    private String description;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
