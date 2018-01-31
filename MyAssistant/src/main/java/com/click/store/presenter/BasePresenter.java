package com.click.store.presenter;


import com.click.store.ui.BaseView;

/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */

public class BasePresenter<M,V extends BaseView> {



    protected M mModel;

    protected V mView;



    public BasePresenter(M m,V v){

        this.mModel=m;
        this.mView = v;

    }




}
