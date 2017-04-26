package com.deity.raillery.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.deity.raillery.R;
import com.deity.raillery.base.BaseRxFragment;
import com.deity.raillery.model.entity.ResponseEntity;

import java.util.Arrays;

import butterknife.BindView;

/**
 * Created by Deity on 2017/4/25.
 */

public class HomeFragment extends BaseRxFragment<HomePresenter> implements IHomeComponent.View {
    @BindView(R.id.home_recyclerView)
    public RecyclerView home_recyclerView;

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
        return R.layout.fragment_home;
    }

    @Override
    public void showDynamic(ResponseEntity entity) {
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), Arrays.asList(entity.getData()),true);
        home_recyclerView.setAdapter(homeAdapter);
    }
}
