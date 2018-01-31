package com.click.store.di.module;

import android.app.Application;

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



    private Application mApplication;


    public AppModule(Application application){

        this.mApplication = application;

    }

    @Provides
    @Singleton
    public Application provideApplication(){


        return  mApplication;
    }



    @Provides
    @Singleton
    public Gson provideGson(){


        return  new Gson();
    }






}
