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

        // todo 後でmarginを調整する
        final int marginPixel = getResources().getDimensionPixelSize(R.dimen.margin_tiny);
        addItemDecoration(new ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
                outRect.set(0, 0, 0, marginPixel);
            }
        });
        setHasFixedSize(true);
    }

    public void addArticleList(List<Article> articleList) {
        adapter.addArticleList(articleList);
    }

    class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
        private List<Article> articleList = new ArrayList<>();

        @Override
        public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // todo 大きい画像と普通のcardViewとで場合分けする
            return new ArticleViewHolder(new CardArticleView(getContext()));
        }

        @Override
        public void onBindViewHolder(ArticleViewHolder holder, int position) {
            Article article = articleList.get(position);
            holder.setArticle(article);
        }

        @Override
        public int getItemCount() {
            return articleList.size();
        }

        void addArticleList(List<Article> articleList) {
            int start = this.articleList.size();
            this.articleList.addAll(articleList);

            notifyItemRangeInserted(start, articleList.size());
        }
    }

    private class ArticleViewHolder extends RecyclerView.ViewHolder {
        public ArticleViewHolder(View itemView) {
            super(itemView);
        }

        public void setArticle(Article article) {
            CardArticleView cardArticleView = (CardArticleView) itemView;
            cardArticleView.setUp(article);
        }
    }
}
