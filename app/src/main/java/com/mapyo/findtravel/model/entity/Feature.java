package com.mapyo.findtravel.model.entity;

import com.mapyo.findtravel.model.TopicGroup;

public class Feature implements TopicGroup {
    int id;
    String image;
    String link;
    String title;

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public Type getType() {
        return Type.FEATURE;
    }
}
