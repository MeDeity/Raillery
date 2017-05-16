package com.deity.raillery.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deity.raillery.R;
import com.deity.raillery.base.BaseRxFragment;
import com.deity.raillery.base.SpaceItemDecoration;
import com.deity.raillery.data.Params;
import com.deity.raillery.model.entity.DynamicEntity;
import com.deity.raillery.model.entity.ResponseEntity;
import com.deity.raillery.utils.I18NData;
import com.othershe.baseadapter.ViewHolder;
import com.othershe.baseadapter.interfaces.OnItemClickListener;
import com.othershe.baseadapter.interfaces.OnLoadMoreListener;

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
    private HomeAdapter homeAdapter;
    /**重新加载*/
    private int currentPage=0;

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
        mSwipeRefreshLayout.setRefreshing(true);
        homeAdapter = new HomeAdapter(getActivity(),null,true);

        //初始化EmptyView
        View emptyView = LayoutInflater.from(getActivity()).inflate(R.layout.empty_layout, (ViewGroup) home_recyclerView.getParent(), false);
        homeAdapter.setEmptyView(emptyView);

        //初始化 开始加载更多的loading View
        homeAdapter.setLoadingView(R.layout.load_loading_layout);

        homeAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                Log.i("onLoadMore","loadDynamicByPage:"+currentPage);
                mPresenter.loadDynamicByPage(currentPage);
            }
        });
        homeAdapter.setOnItemClickListener(new OnItemClickListener<DynamicEntity>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, DynamicEntity data, int position) {
//                Intent imageIntent = new Intent(getActivity(), ImageActivity.class);
//                imageIntent.putExtra(Params.PHOTO_URI,data.getFileUrl());
//                startActivity(imageIntent);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //间距设置
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.recycle_space);
        home_recyclerView.addItemDecoration(new SpaceItemDecoration(spacingInPixels));

        home_recyclerView.setLayoutManager(layoutManager);
        home_recyclerView.setAdapter(homeAdapter);
        mSwipeRefreshLayout.setColorSchemeColors(I18NData.getColor(R.color.colorAccent), I18NData.getColor(R.color.colorPrimary),I18NData.getColor(R.color.colorPrimaryDark));
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
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
        //成功加载的情况下，更新当前页面
        currentPage += 1;
        mSwipeRefreshLayout.setRefreshing(false);
        if (entity.getData().isFirst()){
            homeAdapter.setNewData(Arrays.asList(entity.getData().getContent()));
        }else {
            homeAdapter.setData(Arrays.asList(entity.getData().getContent()));
        }
        if (entity.getData().isLast()){
            showLoadEnd();//已经加载结束了
        }
    }

    @Override
    public void showLoadFail() {
        mSwipeRefreshLayout.setRefreshing(false);
        //初始化 开始加载更多的loading View
        View reloadLayout = LayoutInflater.from(getActivity()).inflate(R.layout.reload_layout, (ViewGroup) home_recyclerView.getParent(), false);
        final View reloadBtn = reloadLayout.findViewById(R.id.load_error_tip);
        final View reloadTip = reloadLayout.findViewById(R.id.reload_tip);
        reloadBtn.setVisibility(View.VISIBLE);
        reloadTip.setVisibility(View.GONE);
        reloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reloadBtn.setVisibility(View.GONE);
                reloadTip.setVisibility(View.VISIBLE);
                Log.i("showLoadFail","loadDynamicByPage:"+currentPage);
                mPresenter.loadDynamicByPage(currentPage);
            }
        });
        homeAdapter.setReloadView(reloadLayout);
    }

    @Override
    public void showLoadEnd() {
        mSwipeRefreshLayout.setRefreshing(false);
        homeAdapter.setLoadEndView(R.layout.load_end_layout);
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        Log.i("onRefresh","loadDynamicByPage(0)");
        mPresenter.loadDynamicByPage(0);
    }
}
