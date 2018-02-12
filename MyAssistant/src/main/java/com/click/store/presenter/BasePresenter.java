package com.click.store.presenter;


import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.click.store.ui.BaseView;

/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */

public class BasePresenter<M,V extends BaseView> {
    protected Context mContext;
    protected M mModel;

    protected V mView;

    public BasePresenter(M m,V v){

        this.mModel=m;
        this.mView = v;

    }

    private void initContext(){



        if(mView instanceof Fragment){
            mContext = ((Fragment)mView).getActivity();
        }
        else {
            mContext = (Activity) mView;
        }
    }
}
