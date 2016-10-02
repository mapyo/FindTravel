package com.mapyo.findtravel.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mapyo.findtravel.R;
import com.mapyo.findtravel.model.entity.PickupFeature;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PickupFeatureListView extends RecyclerView {
    private PickupFeatureAdapter adapter;

    public PickupFeatureListView(Context context) {
        this(context, null);
    }

    public PickupFeatureListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PickupFeatureListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        adapter = new PickupFeatureAdapter();
        setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        setLayoutManager(linearLayoutManager);

        addItemDecoration(new ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
                int marginPixel = getResources().getDimensionPixelSize(R.dimen.margin_small);
                outRect.set(marginPixel, marginPixel, marginPixel, marginPixel);
            }
        });
        setHasFixedSize(true);
    }

    public void addPickupFeatures(List<PickupFeature> pickupFeatures) {
        adapter.addPickupFeatures(pickupFeatures);
    }

    private class PickupFeatureAdapter extends RecyclerView.Adapter<PickupFeatureViewHolder> {
        private List<PickupFeature> pickupFeatureList = new ArrayList<>();

        @Override
        public PickupFeatureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return PickupFeatureViewHolder.create(parent);
        }

        @Override
        public void onBindViewHolder(PickupFeatureViewHolder holder, int position) {
            PickupFeature pickupFeature = pickupFeatureList.get(position);

            Picasso.with(getContext())
                    .load(pickupFeature.getImage())
                    .placeholder(R.color.grey_100)
                    .fit()
                    .centerCrop()
                    .error(R.color.grey_100)
                    .into((ImageView) holder.itemView);
        }

        @Override
        public int getItemCount() {
            return pickupFeatureList.size();
        }

        public void addPickupFeatures(List<PickupFeature> pickupFeatureList) {
            int start = this.pickupFeatureList.size();
            this.pickupFeatureList.addAll(pickupFeatureList);

            notifyItemRangeInserted(start, pickupFeatureList.size());
        }
    }

    static class PickupFeatureViewHolder extends RecyclerView.ViewHolder {
        PickupFeatureViewHolder(View itemView) {
            super(itemView);
        }

        static PickupFeatureViewHolder create(ViewGroup parent) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_image, parent, false);

            return new PickupFeatureViewHolder(v);
        }
    }
}

