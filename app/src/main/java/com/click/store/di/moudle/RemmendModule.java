package com.click.store.di.moudle;

import android.app.ProgressDialog;
import com.click.store.data.RecommendModel;
import com.click.store.data.http.ApiService;
import com.click.store.presenter.contract.RecommendContract;
import com.click.store.presenter.contract.RecommendPresenter;
import com.click.store.ui.fragment.RecommendFragment;
import dagger.Module;
import dagger.Provides;

/**
 * Created by S on 2017/11/22.
 */
@Module
public class RemmendModule {

    private RecommendContract.View mView;


    public RemmendModule(RecommendContract.View view) {
        this.mView = view;
    }

    @Provides
    public RecommendContract.Presenter providePresenter(RecommendContract.View view,RecommendModel model){


        return new RecommendPresenter(view,model);
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
