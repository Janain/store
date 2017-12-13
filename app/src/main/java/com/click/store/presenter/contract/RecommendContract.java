package com.click.store.presenter.contract;

import com.click.store.bean.AppInfo;
import com.click.store.presenter.BasePresenter;
import com.click.store.ui.BaseView;

import java.util.List;

/**
 * Created by S on 2017/11/22.
 *
 */

public interface RecommendContract {

    interface  View extends BaseView{

        void showResult(List<AppInfo> datas);

        void showNoData();

        void showError(String msg);

    }

    interface  Presenter extends BasePresenter{

        void requestDatas();

    }
}
