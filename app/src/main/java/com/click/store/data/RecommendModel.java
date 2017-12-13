package com.click.store.data;

import com.click.store.bean.AppInfo;
import com.click.store.bean.PageBean;
import com.click.store.data.http.ApiService;
import retrofit2.Callback;

/**
 * Created by S on 2017/11/22.
 */

public class RecommendModel {

    public void getApp(Callback<PageBean<AppInfo>> callback){

        HttpManager manager = new HttpManager();
        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
        apiService.getApps("{'page':0}").enqueue(callback);

    }
}
