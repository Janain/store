package com.click.store.di.moudle;

import com.click.store.AppApplication;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */
@Module
public class AppModule {


    public AppApplication mAplication;

    public AppModule(AppApplication appApplication) {

        this.mAplication = appApplication;

    }

    @Provides
    @Singleton
    public AppApplication provideAppAplication(){

        return mAplication;
    }


    @Provides
    @Singleton
    public Gson provideGson(){

        return new Gson();
    }
}
