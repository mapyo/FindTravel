package com.mapyo.findtravel.ui.widget;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mapyo.findtravel.R;
import com.mapyo.findtravel.databinding.ViewCardArticleBinding;
import com.mapyo.findtravel.model.entity.Article;
import com.squareup.picasso.Picasso;

public class CardArticleView extends CardView {
    private ViewCardArticleBinding binding;

    public CardArticleView(Context context) {
        this(context, null);
    }

    public CardArticleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardArticleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.view_card_article, this, true);
    }

    public void bindData(@NonNull Article article, int imageWidth) {
        ViewGroup.LayoutParams lp = binding.cardArticleImage.getLayoutParams();
        lp.width = imageWidth;

        Picasso.with(getContext())
                .load(article.getImage())
                .placeholder(R.color.grey_100)
                .fit()
                .centerCrop()
                .error(R.color.grey_100)
                .into(binding.cardArticleImage);

        binding.cardArticleTitle.setText(article.getTitle());
        binding.cardArticleViews.setText(getResources().getString(R.string.views, article.getViews()));
    }
}
