package com.mapyo.findtravel.ui.widget.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mapyo.findtravel.model.TopTabType;
import com.mapyo.findtravel.ui.fragment.CategoryArticleListFragment;
import com.mapyo.findtravel.ui.fragment.TopicListFragment;


public class MainPagerAdapter extends FragmentStatePagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (TopTabType.getTopTabType(position)) {
            case TOPIC:
                return new TopicListFragment.Builder().build();
            default:
                return new CategoryArticleListFragment.Builder(TopTabType.getTopTabType(position)).build();
        }
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

