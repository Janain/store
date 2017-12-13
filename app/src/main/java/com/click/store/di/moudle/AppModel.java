package com.click.store.di.moudle;

import com.click.store.AppAplication;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by S on 2017/11/23.
 */
@Module
public class AppModel {


    public AppAplication mAplication;

    public AppModel(AppAplication appAplication) {

        this.mAplication = appAplication;

    }

    @Provides
    @Singleton
    public AppAplication provideAppAplication(){

        return mAplication;
    }


    @Provides
    @Singleton
    public Gson provideGson(){

        return new Gson();
    }
}
