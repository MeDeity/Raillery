package com.deity.raillery.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deity.raillery.R;
import com.deity.raillery.base.BaseRxFragment;
import com.deity.raillery.model.entity.ResponseEntity;
import com.deity.raillery.utils.I18NData;

import java.util.Arrays;

import butterknife.BindView;

/**
 * Created by Deity on 2017/4/25.
 */

public class HomeFragment extends BaseRxFragment<HomePresenter> implements IHomeComponent.View,SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.home_recyclerView)
    public RecyclerView home_recyclerView;
    @BindView(R.id.widget_refresh)
    public SwipeRefreshLayout mSwipeRefreshLayout;

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
        mSwipeRefreshLayout.setRefreshing(false);
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), Arrays.asList(entity.getData()),true);

        //初始化EmptyView
        View emptyView = LayoutInflater.from(getActivity()).inflate(R.layout.empty_layout, (ViewGroup) home_recyclerView.getParent(), false);
        homeAdapter.setEmptyView(emptyView);

        //初始化 开始加载更多的loading View
        View reloadLayout = LayoutInflater.from(getActivity()).inflate(R.layout.load_failed_layout, (ViewGroup) home_recyclerView.getParent(), false);
        homeAdapter.setLoadingView(R.layout.load_loading_layout);

//        homeAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore(boolean isReload) {
//                mPresenter.loadDynamicByPage(0);
//            }
//        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        home_recyclerView.setLayoutManager(layoutManager);
        home_recyclerView.setAdapter(homeAdapter);
        mSwipeRefreshLayout.setColorSchemeColors(I18NData.getColor(R.color.colorAccent), I18NData.getColor(R.color.colorPrimary),I18NData.getColor(R.color.colorPrimaryDark));
        mSwipeRefreshLayout.setOnRefreshListener(this);

    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        mPresenter.loadDynamicByPage(0);
    }
}
