package com.mapyo.findtravel.presenter;

import android.content.Context;

import com.mapyo.findtravel.contract.CategoryContract;


public class CategoryPresenter {
    private final CategoryContract.View view;
    // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
    private Context context;

    public CategoryPresenter(CategoryContract.View categoryView, Context context) {
        view = categoryView;
        this.context = context;
    }

    public void fetchCategory() {
        // ファイルからjson取得
        // 表示する
    }
}
