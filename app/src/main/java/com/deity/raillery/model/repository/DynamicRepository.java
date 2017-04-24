package com.deity.raillery.model.repository;

import com.deity.raillery.model.entity.DynamicEntity;
import com.deity.raillery.network.NetWorkEngine;

import io.reactivex.Observable;

/**
 * 动态信息数据获取
 * Created by Deity on 2017/4/24.
 */

public class DynamicRepository {

    /**
     * 分页获取动态数据
     * @param page 当前第几页
     * @return 返回分页数据
     */
    public Observable<DynamicEntity> getDynamicList(int page){
        return NetWorkEngine.getInstance().getApiService().getDynamicList(page);
    }
}
