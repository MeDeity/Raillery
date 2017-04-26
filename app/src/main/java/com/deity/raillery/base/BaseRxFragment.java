package com.deity.raillery.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deity.raillery.utils.ClazzUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Deity on 2017/4/25.
 */

public abstract class BaseRxFragment<P extends BaseRxPresenter> extends Fragment implements BaseView {
    protected P mPresenter;

    @SuppressWarnings("ConstantConditions")
    public BaseRxFragment(){
        mPresenter = ClazzUtils.getGenericInstance(this);
        mPresenter.setView(this);
    }

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentViewId(),container,false);
        if(unbinder ==null){
            unbinder = ButterKnife.bind(this, view);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    /**
     * 此方法在onViewCreated()中调用
     */
    protected void init() {
    }

    /**获取资源*/
    protected abstract int getContentViewId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null!=unbinder){
            unbinder.unbind();
            unbinder = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (null!=mPresenter){
            mPresenter.subscribe();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (null!=mPresenter){
            mPresenter.unsubscribe();
        }
    }
}
