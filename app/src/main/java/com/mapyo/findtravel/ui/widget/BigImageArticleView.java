package com.mapyo.findtravel.ui.widget;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.mapyo.findtravel.R;
import com.mapyo.findtravel.databinding.ViewBigImageArticleBinding;
import com.mapyo.findtravel.model.entity.Article;
import com.squareup.picasso.Picasso;

public class BigImageArticleView extends RelativeLayout {
    private ViewBigImageArticleBinding binding;

    public BigImageArticleView(Context context) {
        this(context, null);
    }

    public BigImageArticleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BigImageArticleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.view_big_image_article, this, true);
    }

    public void bindData(@NonNull Article article) {
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
