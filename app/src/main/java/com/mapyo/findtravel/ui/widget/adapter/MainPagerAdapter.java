package com.mapyo.findtravel.ui.widget.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mapyo.findtravel.ui.fragment.CategoryArticleFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private final String[] TAB_TITLES = {"新着", "特集", "絶景", "グルメ", "沖縄", "東京", "京都"};

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // todo 余力があればCategoryを渡して表示する内容を切り替えられるようにする
        return new CategoryArticleFragment.Builder().build();
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_TITLES[position];
    }
}

