package com.deity.raillery.home;

import com.deity.raillery.model.entity.ResponseEntity;
import com.deity.raillery.model.repository.DynamicRepository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
        repository.getDynamicList(page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    @Override
    public void subscribe() {
        loadDynamicByPage(0);
    }

    Observer<ResponseEntity> observer = new Observer<ResponseEntity>() {
        private Disposable disposable;

        @Override
        public void onSubscribe(Disposable d) {
            disposable = d;
        }

        @Override
        public void onNext(ResponseEntity dynamicEntity) {
            mView.showDynamic(dynamicEntity);
            System.out.println(dynamicEntity.getMessage());
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };
}
