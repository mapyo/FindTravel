package com.mapyo.findtravel.model;

public interface TopicGroup {
    Type getType();

    enum Type {PICKUP_FEATURE, FEATURE, TITLE}
}
