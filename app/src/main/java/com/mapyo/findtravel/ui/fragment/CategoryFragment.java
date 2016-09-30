package com.mapyo.findtravel.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mapyo.findtravel.R;
import com.mapyo.findtravel.contract.CategoryContract;
import com.mapyo.findtravel.presenter.CategoryPresenter;

public class CategoryFragment extends Fragment implements CategoryContract.View {

    private CategoryPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
        presenter = new CategoryPresenter(this, getContext());

        presenter.fetchCategory();

        return view;
    }

    public static class Builder {
        private Bundle mArgs;

        public Builder() {
            mArgs = new Bundle();
        }

        public Fragment build() {
            CategoryFragment fragment = new CategoryFragment();
            fragment.setArguments(mArgs);
            return fragment;
        }
    }
}
