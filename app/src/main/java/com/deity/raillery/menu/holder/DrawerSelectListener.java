package com.deity.raillery.menu.holder;

import com.deity.raillery.model.entity.MenuEntity;

/**
 * Created by Deity on 2017/5/22.
 */

public interface DrawerSelectListener {

    /**
     * 当侧边栏的首页item点击时，调用此方法
     */
    void onDrawerHomeItemSelect(int postion);


    /**
     * 当侧边栏的普通item点击时，调用此方法
     * @param entity
     */
    void onDrawerNormalItemSelect(MenuEntity entity);
}
