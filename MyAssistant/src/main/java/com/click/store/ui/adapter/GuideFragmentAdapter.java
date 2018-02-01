package com.click.store.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Wangjj
 * @Create 2018/2/1.
 * @Content
 */

public class GuideFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragments;

    public GuideFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(List<Fragment> mFragments) {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        } else
            this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
