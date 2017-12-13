package com.click.store;

import android.app.Application;
import android.content.Context;

import com.click.store.di.component.AppComponent;
import com.click.store.di.component.DaggerAppComponent;
import com.click.store.di.moudle.AppModel;
import com.click.store.di.moudle.HttpMoudule;

/**
 * Created by S on 2017/11/23.
 *
 */

public class AppAplication extends Application {



    private AppComponent mAppComponent;


    public static AppAplication get(Context context){

        return (AppAplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent(){

        return mAppComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder().appModel(new AppModel(this)).httpMoudule(new HttpMoudule()).build();

    }
}
