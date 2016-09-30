package com.mapyo.findtravel.contract;

import com.mapyo.findtravel.model.entity.Article;

import java.util.List;

public interface CategoryArticleContract {
    interface View {
        void showError();
        void showArticleList(List<Article> articleList);
    }
}
