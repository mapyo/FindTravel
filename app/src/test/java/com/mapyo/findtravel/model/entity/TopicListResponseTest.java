package com.mapyo.findtravel.model.entity;

import com.google.gson.Gson;
import com.mapyo.findtravel.TestUtils;

import org.junit.Test;

import java.util.List;

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

        List<PickupFeature> pickupFeatures = response.getPickupFeatures();
        List<Feature> features = response.getFeatures();

        assertThat(pickupFeatures.size()).isNotZero();
        assertThat(features.size()).isNotZero();

        PickupFeature pickupFeature = pickupFeatures.get(0);
        assertThat(pickupFeature.getId()).isNotZero();
        assertThat(pickupFeature.getImage()).isNotNull();
        assertThat(pickupFeature.getLink()).isNotNull();

        Feature feature = features.get(0);
        assertThat(feature.getId()).isNotZero();
        assertThat(feature.getImage()).isNotNull();
        assertThat(feature.getLink()).isNotNull();
        assertThat(feature.getTitle()).isNotNull();
    }
}
