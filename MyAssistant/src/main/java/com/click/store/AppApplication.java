package com.click.store;

import android.app.Application;
import android.content.Context;
import com.click.store.di.component.AppComponent;
import com.click.store.di.component.DaggerAppComponent;
import com.click.store.di.module.AppModule;
import com.click.store.di.module.HttpModule;

/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */
public class AppApplication extends Application {

    private AppComponent mAppComponent;

    public static AppApplication get(Context context) {
        return (AppApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {

        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .httpModule(new HttpModule()).build();
    }

}
