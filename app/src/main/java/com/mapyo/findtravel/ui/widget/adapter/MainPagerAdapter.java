package com.mapyo.findtravel.ui.widget.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mapyo.findtravel.model.TopTabType;
import com.mapyo.findtravel.ui.fragment.CategoryArticleListFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new CategoryArticleListFragment.Builder(TopTabType.getTopTabType(position)).build();
    }

    @Override
    public int getCount() {
        return TopTabType.values().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TopTabType.getTopTabType(position).getName();
    }
}

