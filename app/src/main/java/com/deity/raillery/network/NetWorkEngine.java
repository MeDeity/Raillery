package com.deity.raillery.network;

import com.deity.raillery.data.Params;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit网络加载的类
 * Created by Deity on 2017/4/24.
 */

public class NetWorkEngine {

    private static NetWorkEngine mNetWorkEngine = new NetWorkEngine();
    private ApiService apiService;

    private NetWorkEngine(){
        initRetrofit();
    }

    public static NetWorkEngine getInstance(){
        return mNetWorkEngine;
    }

//    private void initClient(){
//
//    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Params.NetWork.WEBSITE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }
}
