package com.deity.raillery.network;

import com.deity.raillery.data.Params;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
    private OkHttpClient mOkHttpClient;

    private NetWorkEngine(){
        initClient();
        initRetrofit();
    }

    public static NetWorkEngine getInstance(){
        return mNetWorkEngine;
    }

    private void initClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient = new OkHttpClient.Builder()
//                .cache(new Cache(ContextUtils.getHttpCacheDir(), Config.Network.HTTP_CACHE_SIZE))
//                .connectTimeout(Config.Network.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
//                .readTimeout(Config.Network.HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS)
//                .addInterceptor(new HttpCacheInterceptor())
                .addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .build();

    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
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
