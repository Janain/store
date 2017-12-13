package com.click.store.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.click.store.ui.bean.FragmentInfo;
import com.click.store.ui.fragment.CategoryFragment;
import com.click.store.ui.fragment.GamesFragment;
import com.click.store.ui.fragment.RankingFragment;
import com.click.store.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S on 2017/11/10.
 * FragmentStatePagerAdapter和FragmentPagerAdapter区别
 *
 * SVG Android path view
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<FragmentInfo> fragments = new ArrayList<>(4);


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private void initFragments(){
        fragments.add(new FragmentInfo("推荐", RecommendFragment.class));
        fragments.add(new FragmentInfo("排行", RankingFragment.class));
        fragments.add(new FragmentInfo("游戏", GamesFragment.class));
        fragments.add(new FragmentInfo("分类", CategoryFragment.class));

    }

    @Override
    public Fragment getItem(int position) {
//        Fragment fragment = null;
//        switch (position){
//            case 0:
//                fragment = new RankingFragment();
//                break;
//            case 1:
//                fragment = new RecommendFragment();
//                break;
//            case 2:
//                fragment = new CategoryFragment();
//                break;
//            case 3:
//                fragment = new GamesFragment();
//                break;
//        }


        try {
            return (Fragment) fragments.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();

    }
}
