package com.deity.raillery.menu.holder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deity.raillery.HomeActivity;
import com.deity.raillery.R;
import com.deity.raillery.model.entity.MenuEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Deity on 2017/5/18.
 */

public class DrawerFragment extends Fragment implements DrawerSelectListener{

    @BindView(R.id.nav_rv_content)
    RecyclerView mRvContent;


    private DrawerAdapter mDrawerAdapter;
    private LinearLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu,container,false);
        ButterKnife.bind(this,view);
        init();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public List<MenuEntity> menuEntityTest(){
        List<MenuEntity> menuEntities = new ArrayList<>();
        MenuEntity entity = new MenuEntity();
        entity.setMenuId(0);
        entity.setDescription("测试");
        menuEntities.add(entity);
        return menuEntities;
    }

    protected void init() {
        mDrawerAdapter = new DrawerAdapter(getActivity(),menuEntityTest());
        mDrawerAdapter.setmDrawerSelectistener(this);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRvContent.setLayoutManager(mLayoutManager);
        mRvContent.setAdapter(mDrawerAdapter);
    }

    /**
     * 当侧边栏的首页item点击时，调用此方法
     */
    @Override
    public void onDrawerHomeItemSelect(int postion) {
        HomeActivity activity = (HomeActivity) getActivity();
        if (activity != null) {
            DrawerSelectListener listener = (DrawerSelectListener) activity;
            listener.onDrawerHomeItemSelect(postion);
        }
    }

    /**
     * 当侧边栏的普通item点击时，调用此方法
     *
     * @param entity
     */
    @Override
    public void onDrawerNormalItemSelect(MenuEntity entity) {
        HomeActivity activity = (HomeActivity) getActivity();
        if (activity != null) {
            DrawerSelectListener listener = (DrawerSelectListener) activity;
            listener.onDrawerNormalItemSelect(entity);
        }
    }
}
