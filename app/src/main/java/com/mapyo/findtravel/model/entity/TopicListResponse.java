package com.mapyo.findtravel.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopicListResponse {
    @SerializedName("pickup_features")
    private List<PickupFeature> pickupFeatures;

    private List<Feature> features;

    public List<PickupFeature> getPickupFeatures() {
        return pickupFeatures;
    }

    public List<Feature> getFeatures() {
        return features;
    }
}
