package com.click.store.presenter;


import com.click.store.bean.AppInfo;
import com.click.store.bean.PageBean;
import com.click.store.data.RecommendModel;
import com.click.store.presenter.contract.RecommendContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */

public class RecommendPresenter extends BasePresenter<RecommendModel,RecommendContract.View> {

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);
    }




    public void requestDatas() {


        mView.showLodading();

        mModel.getApps(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {

                if(response !=null){

                    mView.showResult(response.body().getDatas());
                }
                else{
                    mView.showNodata();
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
