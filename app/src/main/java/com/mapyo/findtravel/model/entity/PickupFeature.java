package com.mapyo.findtravel.model.entity;

import com.mapyo.findtravel.model.TopicGroup;

public class PickupFeature implements TopicGroup {
    int id;
    String image;
    String link;

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

    @Override
    public Type getType() {
        return Type.FEATURE;
    }
}
