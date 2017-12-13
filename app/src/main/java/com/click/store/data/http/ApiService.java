package com.click.store.data.http;

import com.click.store.bean.AppInfo;
import com.click.store.bean.PageBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by S on 2017/11/21.
 */

public interface ApiService {
    public static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";
    @GET("featured")
    public Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);

}
