package com.click.store.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.click.store.AppAplication;
import com.click.store.R;
import com.click.store.bean.AppInfo;
import com.click.store.di.component.DaggerRemmendComponent;
import com.click.store.di.moudle.RemmendModule;
import com.click.store.presenter.contract.RecommendContract;
import com.click.store.ui.adapter.RecomendAppAdapter;
import com.click.store.common.until.DividerItemDecoration;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by S on 2017/11/10.
 *
 */
public class RecommendFragment extends Fragment implements RecommendContract.View {

    private RecomendAppAdapter appAdapter;
    @Inject
    ProgressDialog mProgessDialog;

    @Inject
    RecommendContract.Presenter presenter;

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recomend, container, false);




        DaggerRemmendComponent.builder().appComponent(((AppAplication)getActivity().getApplication()).
                getAppComponent()).remmendModule(new RemmendModule(this)).build().inject(this);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;


    }


    public void initData(){

        presenter.requestDatas();

    }
    public void recycleView(List<AppInfo> datas){
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL_LIST));
        recycleView.setItemAnimator(new DefaultItemAnimator());

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

//        recycleView.setLayoutManager(linearLayoutManager);
        appAdapter = new RecomendAppAdapter(getActivity(),datas);
        recycleView.setAdapter(appAdapter);
        appAdapter.notifyItemChanged(1);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLoading() {
      //  mProgessDialog.show();
    }

    @Override
    public void dimissLoading() {
//        if(mProgessDialog.isShowing()){
//            mProgessDialog.dismiss();
//        }
    }

    @Override
    public void showResult(List<AppInfo> datas) {

        recycleView(datas);

    }

    @Override
    public void showNoData() {
        Toast.makeText(getActivity(),"暂时没有数据",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(),"服务器开小差了："+msg,Toast.LENGTH_LONG).show();
    }
}
