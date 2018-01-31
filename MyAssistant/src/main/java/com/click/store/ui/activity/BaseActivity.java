package com.click.store.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import com.click.store.AppApplication;
import com.click.store.di.component.AppComponent;
import com.click.store.presenter.BasePresenter;
import com.mikepenz.iconics.context.IconicsLayoutInflater;
import javax.inject.Inject;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private Unbinder mUnbinder;

    private AppApplication mApplication;

    @Inject
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);

        setContentView(setLayout());

        mUnbinder = ButterKnife.bind(this);
        this.mApplication = (AppApplication) getApplication();

        setupAcitivtyComponent(mApplication.getAppComponent());

        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mUnbinder != Unbinder.EMPTY) {

            mUnbinder.unbind();
        }
    }

    public abstract int setLayout();

    public abstract void setupAcitivtyComponent(AppComponent appComponent);

    public abstract void init();

}
