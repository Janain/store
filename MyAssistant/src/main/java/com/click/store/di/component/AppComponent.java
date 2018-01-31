package com.click.store.di.component;


import com.click.store.data.http.ApiService;
import com.click.store.di.module.AppModule;
import com.click.store.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {


    public ApiService getApiService();
}
