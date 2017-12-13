package com.click.store.presenter.contract;

import com.click.store.bean.AppInfo;
import com.click.store.bean.PageBean;
import com.click.store.data.RecommendModel;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by S on 2017/11/22.
 */

public class RecommendPresenter implements RecommendContract.Presenter {

    private RecommendModel mModel;

    private RecommendContract.View mView;
    @Inject
    public RecommendPresenter(RecommendContract.View view,RecommendModel model){
        this.mView = view;
        mModel = model;

    }


    @Override
    public void requestDatas() {

        mView.showLoading();

        mModel.getApp(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {

                if(response != null){
                    mView.showResult(response.body().getDatas());

                }else{
                    mView.showNoData();
                }
                mView.dimissLoading();
            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
                mView.dimissLoading();
                mView.showError(t.getMessage());
            }
        });

    }
}

