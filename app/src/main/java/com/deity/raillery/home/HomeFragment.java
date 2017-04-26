package com.deity.raillery.home;

import android.os.Bundle;

import com.deity.raillery.base.BaseRxFragment;
import com.deity.raillery.model.entity.ResponseEntity;

/**
 * Created by Deity on 2017/4/25.
 */

public class HomeFragment extends BaseRxFragment<HomePresenter> implements IHomeComponent.View {

    public static HomeFragment newInstance(Bundle args) {
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected void init() {
        super.init();

    }

    /**
     * 获取资源
     */
    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    public void showDynamic(ResponseEntity entity) {

    }
}
