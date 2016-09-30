package com.mapyo.findtravel.ui.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

import com.mapyo.findtravel.model.entity.Article;

public class CardArticleView extends CardView {
    public CardArticleView(Context context) {
        this(context, null);
    }

    public CardArticleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardArticleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setUp(Article article) {

    }
}
