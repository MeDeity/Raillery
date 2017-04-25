package com.deity.raillery.home;

import com.deity.raillery.model.entity.DynamicEntity;
import com.deity.raillery.model.repository.DynamicRepository;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Deity on 2017/4/25.
 */

public class HomePresenter extends IHomeComponent.Presenter<DynamicRepository> {
    /**
     * 分页加载动态消息数据
     *
     * @param page 当前页数
     */
    @Override
    void loadDynamicByPage(int page) {
        repository.getDynamicList(page).subscribe(new Consumer<DynamicEntity>() {
            @Override
            public void accept(@NonNull DynamicEntity dynamicEntity) throws Exception {
                mView.showDynamic(dynamicEntity);
            }
        });
    }

    @Override
    public void subscribe() {
        loadDynamicByPage(0);
    }
}
