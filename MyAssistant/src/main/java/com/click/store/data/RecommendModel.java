package com.click.store.data;


import com.click.store.bean.AppInfo;
import com.click.store.bean.PageBean;
import com.click.store.data.http.ApiService;

import retrofit2.Callback;
import rx.Observable;

/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */
public class RecommendModel {

    private ApiService mApiService;

    public RecommendModel(ApiService apiService) {

        this.mApiService = apiService;
    }


    public Observable<PageBean<AppInfo>> getApps( ) {


//
//        HttpManager manager = new HttpManager();
//
//        ApiService apiService =manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);


//        mApiService.getApps("{'page':0}").enqueue(callback);
        return mApiService.getApps("{'page':0}");

    }


}
