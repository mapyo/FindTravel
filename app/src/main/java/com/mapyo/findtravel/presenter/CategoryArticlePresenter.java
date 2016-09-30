package com.mapyo.findtravel.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.mapyo.findtravel.contract.CategoryArticleContract;
import com.mapyo.findtravel.model.JsonCreator;
import com.mapyo.findtravel.model.entity.CategoryArticleListResponse;

import java.io.IOException;


// todo CategoryArticleListの方がよい気がしてきた
public class CategoryArticlePresenter {
    private final CategoryArticleContract.View view;
    private static final String JSON_FILE = "ranking.json";

    // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
    private Context context;

    public CategoryArticlePresenter(CategoryArticleContract.View categoryArticleView, Context context) {
        view = categoryArticleView;
        // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
        this.context = context;
    }

    public void fetchCategory() {
        // ファイルからjson取得
        String jsonString;
        try {
            jsonString = JsonCreator.readFromAssets(context, JSON_FILE);
        } catch (IOException e) {
            e.printStackTrace();
            jsonString = null;
            view.showError();
        }

        CategoryArticleListResponse responses = new Gson().fromJson(jsonString, CategoryArticleListResponse.class);
        view.showArticleList(responses.getArticleList());
    }
}
