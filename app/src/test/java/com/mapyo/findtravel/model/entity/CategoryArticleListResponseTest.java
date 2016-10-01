package com.mapyo.findtravel.model.entity;

import com.google.gson.Gson;
import com.mapyo.findtravel.TestUtils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryArticleListResponseTest {
    @Test
    public void paceJson() throws Exception {
        Gson gson = new Gson();
        CategoryArticleListResponse response =
                gson.fromJson(
                        TestUtils.getAssetFileString("new_arrival.json"),
                        CategoryArticleListResponse.class
                );

        assertThat(response.getTotalCount()).isNotZero();
        assertThat(response.getArticleList().size()).isNotZero();
        assertThat(response.getArticleList().get(0)).isInstanceOf(Article.class);
    }
}
