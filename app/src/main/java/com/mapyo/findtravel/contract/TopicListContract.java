package com.mapyo.findtravel.contract;

import com.mapyo.findtravel.model.entity.Feature;
import com.mapyo.findtravel.model.entity.PickupFeature;

import java.util.List;

public interface TopicListContract {
    interface View {
        void showError();
        void showPickupFeatures(List<PickupFeature> pickupFeatures);
        void showFeatures(List<Feature> features);
    }
}
