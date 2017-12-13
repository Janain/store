package com.click.store.di.component;

import com.click.store.data.http.ApiService;
import com.click.store.di.moudle.AppModel;
import com.click.store.di.moudle.HttpMoudule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by S on 2017/11/23.
 */

@Singleton
@Component(modules = {AppModel.class, HttpMoudule.class})
public interface AppComponent {

    public ApiService getApiService();


}
