package com.mapyo.findtravel.model.entity;

import com.google.gson.Gson;
import com.mapyo.findtravel.TestUtils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TopicListResponseTest {
    @Test
    public void paceJson() throws Exception {
        Gson gson = new Gson();
        TopicListResponse response =
                gson.fromJson(
                        TestUtils.getAssetFileString("topic.json"),
                        TopicListResponse.class
                );

        assertThat(response.getPickupFeatures().size()).isNotZero();
        assertThat(response.getPickupFeatures().get(0)).isInstanceOf(PickupFeature.class);
        assertThat(response.getFeatures().size()).isNotZero();
        assertThat(response.getFeatures().get(0)).isInstanceOf(Feature.class);
    }
}
