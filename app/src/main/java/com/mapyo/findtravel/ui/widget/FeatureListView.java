package com.mapyo.findtravel.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mapyo.findtravel.R;
import com.mapyo.findtravel.model.entity.Feature;

import java.util.ArrayList;
import java.util.List;

public class FeatureListView extends RecyclerView {
    private FeatureAdapter adapter;

    public FeatureListView(Context context) {
        this(context, null);
    }

    public FeatureListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeatureListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        adapter = new FeatureAdapter();
        setAdapter(adapter);

        setLayoutManager(new GridLayoutManager(context, 2));

        addItemDecoration(new ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
                int marginPixel = getResources().getDimensionPixelSize(R.dimen.margin_small);
                outRect.set(marginPixel, marginPixel, marginPixel, marginPixel);
            }
        });

        setHasFixedSize(true);
    }

    public void addFeatures(List<Feature> features) {
        adapter.addFeatures(features);
    }

    private class FeatureAdapter extends Adapter<FeatureViewHolder> {
        private List<Feature> featureList = new ArrayList<>();

        @Override
        public FeatureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return FeatureViewHolder.create(parent);
        }

        @Override
        public void onBindViewHolder(FeatureViewHolder holder, int position) {
            Feature feature = featureList.get(position);
            holder.bind(feature);
        }

        @Override
        public int getItemCount() {
            return featureList.size();
        }

        public void addFeatures(List<Feature> featureList) {
            int start = this.featureList.size();
            this.featureList.addAll(featureList);

            notifyItemRangeInserted(start, featureList.size());
        }
    }

    static class FeatureViewHolder extends ViewHolder {
        int imageWidth;

        FeatureViewHolder(View itemView, int imageWidth) {
            super(itemView);
            this.imageWidth = imageWidth;
        }

        public void bind(Feature feature) {
            // todo
        }

        static FeatureViewHolder create(ViewGroup parent) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_card_feature, parent, false);
            int imageWidth = parent.getWidth() / 2;

            return new FeatureViewHolder(v, imageWidth);
        }
    }
}

