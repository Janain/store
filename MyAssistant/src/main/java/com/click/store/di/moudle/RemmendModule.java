package com.click.store.di.moudle;

import android.app.ProgressDialog;
import com.click.store.data.RecommendModel;
import com.click.store.data.http.ApiService;
import com.click.store.presenter.contract.RecommendContract;
import com.click.store.ui.fragment.RecommendFragment;
import dagger.Module;
import dagger.Provides;

/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */
@Module
public class RemmendModule {

    private RecommendContract.View mView;


    public RemmendModule(RecommendContract.View view) {
        this.mView = view;
    }


    @Provides
    public RecommendContract.View provideView(){

        return mView;
    }

    @Provides
    public RecommendModel privodeModel(ApiService apiService){

        return new RecommendModel(apiService);
    }

    @Provides
    public ProgressDialog provideProgressDialog(RecommendContract.View view){

        return new ProgressDialog(((RecommendFragment) view).getActivity());
    }
}