package com.mapyo.findtravel.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryArticleListResponse {
    @SerializedName("data")
    private List<Article> articleList;

    @SerializedName("total_count")
    private int totalCount;

    public List<Article> getArticleList() {
        return articleList;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
