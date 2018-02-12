package com.click.store.presenter;

import android.Manifest;
import android.app.Activity;

import com.click.store.bean.AppInfo;
import com.click.store.bean.PageBean;
import com.click.store.common.rx.RxHttpReponseCompat;
import com.click.store.common.rx.subscriber.ProgressDialogSubcriber;
import com.click.store.data.RecommendModel;
import com.click.store.presenter.contract.RecommendContract;
import com.tbruyelle.rxpermissions.RxPermissions;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;


public class RecommendPresenter extends BasePresenter<RecommendModel,RecommendContract.View> {




    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);

    }




//    public void requestPermission(){
//
//
//        RxPermissions rxPermissions = new RxPermissions((Activity) mContext);
//
//        rxPermissions.request(Manifest.permission.READ_PHONE_STATE).subscribe(new Action1<Boolean>() {
//            @Override
//            public void call(Boolean aBoolean) {
//                if(aBoolean){
//
//                    mView.onRequestPermissonSuccess();
//                }
//                else{
//
//                    mView.onRequestPermissonError();
//                }
//            }
//        });
//
//    }




    public void requestDatas() {


        RxPermissions rxPermissions = new RxPermissions((Activity) mContext);

        rxPermissions.request(Manifest.permission.READ_PHONE_STATE)
                .flatMap(new Func1<Boolean, Observable<PageBean<AppInfo>>>() {
                    @Override
                    public Observable<PageBean<AppInfo>>call(Boolean aBoolean) {

                        if(aBoolean){

                            return  mModel.getApps().compose(RxHttpReponseCompat.<PageBean<AppInfo>>compatResult());
                        }
                        else{

                            return Observable.empty();
                        }


                    }
                }).subscribe(new ProgressDialogSubcriber<PageBean<AppInfo>>(mContext) {
                    @Override
                    public void onNext(PageBean<AppInfo> appInfoPageBean) {
                        mView.showResult(appInfoPageBean.getDatas());
                    }
                });


//        mModel.getApps()
//
//                .compose(RxHttpReponseCompat.<PageBean<AppInfo>>compatResult())
//                .subscribe(new ProgressDialogSubcriber<PageBean<AppInfo>>(mContext) {
//
//
//                    @Override
//                    public void onNext(PageBean<AppInfo> appInfoPageBean) {
//                        mView.showResult(appInfoPageBean.getDatas());
//                    }
//
//
//                });



//
//        mModel.getApps(new Callback<PageBean<AppInfo>>() {
//            @Override
//            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
//
//                if(response !=null){
//
//                    mView.showResult(response.body().getDatas());
//                }
//                else{
//                    mView.showNodata();
//                }
//
//                mView.dimissLoading();
//
//            }
//
//            @Override
//            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
//
//                mView.dimissLoading();
//                mView.showError(t.getMessage());
//
//            }
//        });
    }
}
