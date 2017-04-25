package com.deity.raillery.base;

/**
 * 粘合器基类
 * Created by Deity on 2017/4/25.
 */

@SuppressWarnings("unused")
public interface BasePresenter<V extends BaseView>{
    void setView(V view);
    void subscribe();
    void unsubscribe();
}
