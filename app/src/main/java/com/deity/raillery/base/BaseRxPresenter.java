package com.deity.raillery.base;

import android.view.View;

import com.deity.raillery.utils.ClazzUtils;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Deity on 2017/4/25.
 */

public abstract class BaseRxPresenter<R,V extends BaseView> implements BasePresenter<V> {
    /**数据源*/
    protected R repository;
    /**视图*/
    protected V mView;

    /**实例化数据源*/
    public BaseRxPresenter(){
        repository = ClazzUtils.getGenericInstance(this);
    }

    private CompositeDisposable composite = new CompositeDisposable();

    public boolean addDisposable(CompositeDisposable composite){
        return composite.add(composite);
    }

    @Override
    public void unsubscribe() {
        composite.clear();
    }

    @Override
    public void setView(V view) {
        mView = view;
    }
}
