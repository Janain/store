package com.click.store.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.click.store.R;
import com.click.store.common.Constant;
import com.click.store.common.util.ACache;
import com.click.store.ui.adapter.GuideFragmentAdapter;
import com.click.store.ui.fragment.GuideFragment;
import com.click.store.ui.widget.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author Wangjj
 * @Create 2018/2/1.
 * @Content
 */

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.btn_enter)
    Button mBtnEnter;
    @BindView(R.id.activity_guide)
    RelativeLayout activityGuide;
    GuideFragmentAdapter mAdapter;
    @BindView(R.id.indicator)
    CircleIndicator indicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(GuideFragment.newInstance(R.drawable.guide_1, R.color.color_bg_guide1, R.string.guide_1));
        fragments.add(GuideFragment.newInstance(R.drawable.guide_2, R.color.color_bg_guide2, R.string.guide_2));
        fragments.add(GuideFragment.newInstance(R.drawable.guide_3, R.color.color_bg_guide3, R.string.guide_3));

        mAdapter = new GuideFragmentAdapter(getSupportFragmentManager());
        mAdapter.setFragments(fragments);
        viewpager.setCurrentItem(0);
        viewpager.setOffscreenPageLimit(mAdapter.getCount());
        viewpager.setAdapter(mAdapter);
        viewpager.addOnPageChangeListener(this);

//        mViewpager.setPageTransformer();

        indicator.setViewPager(viewpager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        mBtnEnter.setVisibility((position == mAdapter.getCount() - 1) ? View.VISIBLE : View.GONE);

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @OnClick(R.id.btn_enter)
    public void onClick() {

        ACache.get(this).put(Constant.IS_SHOW_GUIDE, "0");
        startActivity(new Intent(this, MainActivity.class));
        this.finish();

    }

}
