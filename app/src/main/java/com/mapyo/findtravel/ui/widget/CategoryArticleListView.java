package com.mapyo.findtravel.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.mapyo.findtravel.R;
import com.mapyo.findtravel.model.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class CategoryArticleListView extends RecyclerView {
    private ArticleAdapter adapter;

    private static final int TYPE_CATEGORY = 0;
    private static final int TYPE_BIG_IMAGE = 1;

    public CategoryArticleListView(Context context) {
        this(context, null);
    }

    public CategoryArticleListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CategoryArticleListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        adapter = new ArticleAdapter();
        setAdapter(adapter);
        setLayoutManager(new LinearLayoutManager(context));

        final int marginPixel = getResources().getDimensionPixelSize(R.dimen.margin_small);
        addItemDecoration(new ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
                outRect.set(marginPixel, 0, marginPixel, marginPixel);
            }
        });
        setHasFixedSize(true);
    }

    public void addArticleList(List<Article> articleList) {
        adapter.addArticleList(articleList);
    }

    private class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
        private List<Article> articleList = new ArrayList<>();


        @Override
        public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            switch (viewType) {
                case TYPE_CATEGORY:
                    return new ArticleViewHolder(new CardArticleView(getContext()));
                case TYPE_BIG_IMAGE:
                    return new ArticleViewHolder(new BigImageArticleView(getContext()));
                default:
                    throw new RuntimeException("ViewType is invalid: " + viewType);

            }
        }

        @Override
        public void onBindViewHolder(ArticleViewHolder holder, int position) {
            Article article = articleList.get(position);
            holder.bind(article, getItemViewType(position));
        }

        @Override
        public int getItemCount() {
            return articleList.size();
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return TYPE_BIG_IMAGE;
            } else {
                return TYPE_CATEGORY;
            }
        }

        void addArticleList(List<Article> articleList) {
            int start = this.articleList.size();
            this.articleList.addAll(articleList);

            notifyItemRangeInserted(start, articleList.size());
        }
    }

    private class ArticleViewHolder extends RecyclerView.ViewHolder {
        ArticleViewHolder(View itemView) {
            super(itemView);
        }

        void bind(Article article, int itemType) {
            switch (itemType) {
                case TYPE_BIG_IMAGE:
                    ((BigImageArticleView) itemView).bindData(article);
                    return;
                case TYPE_CATEGORY:
                default:
                    ((CardArticleView) itemView).bindData(article);
                    return;
            }
        }
    }
}

