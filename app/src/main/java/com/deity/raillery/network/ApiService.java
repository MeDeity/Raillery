package com.deity.raillery.network;


import com.deity.raillery.model.entity.ResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 网络数据访问
 * Created by Deity on 2017/4/24.
 */

public interface ApiService {

    @GET("dynamic/query/{page}")
    Observable<ResponseEntity> getDynamicList(@Path("page") int page);

    @GET("dynamic/queryAll")
    Observable<ResponseEntity> getDynamicList();
}
