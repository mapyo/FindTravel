package com.mapyo.findtravel.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mapyo.findtravel.R;
import com.mapyo.findtravel.contract.CategoryArticleListContract;
import com.mapyo.findtravel.databinding.FragmentCategoryArticleListBinding;
import com.mapyo.findtravel.model.entity.Article;
import com.mapyo.findtravel.presenter.CategoryArticleListPresenter;

import java.util.List;

public class CategoryArticleListFragment extends Fragment implements CategoryArticleListContract.View {

    private CategoryArticleListPresenter presenter;
    private FragmentCategoryArticleListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCategoryArticleListBinding.inflate(inflater, container, false);

        // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
        presenter = new CategoryArticleListPresenter(this, getContext());
        presenter.fetchCategory();

        return binding.getRoot();
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), R.string.failed_fetch_article, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showArticleList(List<Article> articleList) {
        binding.fragmentCategoryArticleListView.addArticleList(articleList);
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
