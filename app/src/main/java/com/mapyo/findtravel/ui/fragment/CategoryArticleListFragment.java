package com.mapyo.findtravel.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mapyo.findtravel.R;
import com.mapyo.findtravel.contract.CategoryArticleListContract;
import com.mapyo.findtravel.presenter.CategoryArticleListPresenter;

public class CategoryArticleListFragment extends Fragment implements CategoryArticleListContract.View {

    private CategoryArticleListPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
        presenter = new CategoryArticleListPresenter(this, getContext());

        presenter.fetchCategory();

        return view;
    }

    public static class Builder {
        private Bundle mArgs;

        public Builder() {
            mArgs = new Bundle();
        }

        public Fragment build() {
            CategoryArticleListFragment fragment = new CategoryArticleListFragment();
            fragment.setArguments(mArgs);
            return fragment;
        }
    }
}
