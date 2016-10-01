package com.mapyo.findtravel.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.mapyo.findtravel.contract.CategoryArticleListContract;
import com.mapyo.findtravel.model.JsonCreator;
import com.mapyo.findtravel.model.TopTabType;
import com.mapyo.findtravel.model.entity.CategoryArticleListResponse;

import java.io.IOException;


public class CategoryArticleListPresenter {
    private final CategoryArticleListContract.View view;

    // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
    private Context context;

    public CategoryArticleListPresenter(CategoryArticleListContract.View view, Context context) {
        this.view = view;
        // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
        this.context = context;
    }

    public void fetchCategory(TopTabType topTabType) {
        // ファイルからjson取得
        String jsonString;
        try {
            jsonString = JsonCreator.readFromAssets(context, topTabType.getJsonFile());
        } catch (IOException e) {
            e.printStackTrace();
            jsonString = null;
            view.showError();
        }

        CategoryArticleListResponse responses = new Gson().fromJson(jsonString, CategoryArticleListResponse.class);
        view.showArticleList(responses.getArticleList());
    }
}
