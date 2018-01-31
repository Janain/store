package com.click.store.presenter.contract;


import com.click.store.bean.AppInfo;
import com.click.store.ui.BaseView;

import java.util.List;
/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */

public interface RecommendContract {


    interface View extends BaseView {





        void  showResult(List<AppInfo> datas);
        void showNodata();
        void showError(String msg);



    }



}
