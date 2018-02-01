package com.click.store.presenter;


import com.click.store.bean.AppInfo;
import com.click.store.bean.PageBean;
import com.click.store.data.RecommendModel;
import com.click.store.presenter.contract.RecommendContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */

public class RecommendPresenter extends BasePresenter<RecommendModel, RecommendContract.View> {

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);
    }

    public void requestDatas() {

        mModel.getApps()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PageBean<AppInfo>>() {

                    @Override
                    public void onStart() {
                        mView.showLodading();
                    }

                    @Override
                    public void onCompleted() {
                        mView.dimissLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.dimissLoading();
                    }

                    @Override
                    public void onNext(PageBean<AppInfo> response) {
                        if (response != null) {

                            mView.showResult(response.getDatas());
                        } else {
                            mView.showNodata();
                        }
                    }
                });
    }
}
