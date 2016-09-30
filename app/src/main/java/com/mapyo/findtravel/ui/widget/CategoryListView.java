package com.mapyo.findtravel.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class CategoryListView extends RecyclerView {

    public CategoryListView(Context context) {
        this(context, null);
    }

    public CategoryListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CategoryListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}

