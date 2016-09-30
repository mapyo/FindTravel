package com.mapyo.findtravel.presenter;

import android.content.Context;

import com.mapyo.findtravel.contract.CategoryArticleContract;


public class CategoryArticlePresenter {
    private final CategoryArticleContract.View view;
    // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
    private Context context;

    public CategoryArticlePresenter(CategoryArticleContract.View categoryArticleView, Context context) {
        view = categoryArticleView;
        // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
        this.context = context;
    }

    public void fetchCategory() {
        // ファイルからjson取得
        // 表示する
    }
}
