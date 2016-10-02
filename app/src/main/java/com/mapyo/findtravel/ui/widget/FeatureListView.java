package com.mapyo.findtravel.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import com.mapyo.findtravel.R;
import com.mapyo.findtravel.databinding.ViewCardFeatureBinding;
import com.mapyo.findtravel.model.entity.Feature;
import com.squareup.picasso.Picasso;

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

    private class FeatureAdapter extends Adapter<BindingHolder> {
        private List<Feature> featureList = new ArrayList<>();
        private int imageWidth;

        @Override
        public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            imageWidth = (int) (metrics.widthPixels / 2);

            return new BindingHolder<>(getContext(), parent, R.layout.view_card_feature);
        }

        @Override
        public void onBindViewHolder(BindingHolder holder, int position) {
            Feature feature = featureList.get(position);
            ViewCardFeatureBinding binding = (ViewCardFeatureBinding) holder.binding;
            binding.setFeature(feature);

            ViewGroup.LayoutParams params = binding.featureImageView.getLayoutParams();
            params.width = imageWidth;
            params.height = (int) ((float) imageWidth / 4 * 3);

            Picasso.with(getContext())
                    .load(feature.getImage())
                    .placeholder(R.color.grey_100)
                    .fit()
                    .centerCrop()
                    .error(R.color.grey_100)
                    .into(binding.featureImageView);
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
}

