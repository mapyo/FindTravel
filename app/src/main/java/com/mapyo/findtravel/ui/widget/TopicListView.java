package com.mapyo.findtravel.ui.widget;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.mapyo.findtravel.R;
import com.mapyo.findtravel.databinding.ItemFeatureListViewBinding;
import com.mapyo.findtravel.databinding.ItemPickupFeatureListViewBinding;
import com.mapyo.findtravel.databinding.ItemTopicTitleBinding;
import com.mapyo.findtravel.model.TopicGroup;
import com.mapyo.findtravel.model.entity.Feature;
import com.mapyo.findtravel.model.entity.PickupFeature;

import java.util.List;

public class TopicListView extends RecyclerView {
    private TopicAdapter adapter;

    public TopicListView(Context context) {
        this(context, null);
    }

    public TopicListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopicListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        adapter = new TopicAdapter(context);
        setAdapter(adapter);

        setLayoutManager(new LinearLayoutManager(context));

        addItemDecoration(new ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
                int marginPixel = getResources().getDimensionPixelSize(R.dimen.margin_small);
                outRect.set(marginPixel, marginPixel, marginPixel, marginPixel);
            }
        });

        setHasFixedSize(true);
    }

    public void addPickupFeature(List<PickupFeature> pickupFeatureList) {
        TopicGroup titleTopicGroup = new TopicTitle("ピックアップ特集");
        TopicGroup pickupFeatureTopicGroup = new TopicPickupFeatureList(pickupFeatureList);

        adapter.addItem(titleTopicGroup);
        adapter.addItem(pickupFeatureTopicGroup);
    }

    public void addFeature(List<Feature> featureList) {
        TopicGroup titleTopicGroup = new TopicTitle("その他の特集");
        TopicGroup featureTopicGroup = new TopicFeatureList(featureList);

        adapter.addItem(titleTopicGroup);
        adapter.addItem(featureTopicGroup);
    }

    private class TopicAdapter extends ArrayRecyclerAdapter<TopicGroup, BindingHolder<ViewDataBinding>> {
        private static final int TYPE_PICKUP_FEATURE = 0;
        private static final int TYPE_FEATURE = 1;
        private static final int TYPE_TITLE = 2;

        TopicAdapter(@NonNull Context context) {
            super(context);
        }

        @Override
        public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            switch(viewType) {
                case TYPE_PICKUP_FEATURE:
                    return new BindingHolder<>(getContext(), parent, R.layout.item_pickup_feature_list_view);
                case TYPE_FEATURE:
                    return new BindingHolder<>(getContext(), parent, R.layout.item_feature_list_view);
                case TYPE_TITLE:
                    return new BindingHolder<>(getContext(), parent, R.layout.item_topic_title);
                default:
                    throw new RuntimeException("ViewType is invalid: " + viewType);
            }
        }

        @Override
        public void onBindViewHolder(BindingHolder<ViewDataBinding> holder, int position) {
            TopicGroup topicGroup = getItem(position);

            switch (topicGroup.getType()) {
                case PICKUP_FEATURE:
                    ItemPickupFeatureListViewBinding pickupFeatureListViewBinding = (ItemPickupFeatureListViewBinding) holder.binding;
                    pickupFeatureListViewBinding.featurePickupListView.addPickupFeatures(((TopicPickupFeatureList) topicGroup).getPickupFeatureList());
                    break;
                case FEATURE:
                    ItemFeatureListViewBinding featureListViewBinding = (ItemFeatureListViewBinding) holder.binding;
                    featureListViewBinding.featureListView.addFeatures(((TopicFeatureList) topicGroup).getFeatureList());
                    break;
                default:
                    ItemTopicTitleBinding titleBinding = (ItemTopicTitleBinding) holder.binding;
                    titleBinding.topicTitle.setText(((TopicTitle) topicGroup).getTitle());
                    break;
            }
        }

        @Override
        public int getItemViewType(int position) {
            TopicGroup topicGroup = getItem(position);

            switch (topicGroup.getType()) {
                case PICKUP_FEATURE:
                    return TYPE_PICKUP_FEATURE;
                case FEATURE:
                    return TYPE_FEATURE;
                case TITLE:
                    return TYPE_TITLE;
                default:
                    throw new IllegalStateException("ViewType: " + topicGroup.getType() + " is invalid.");
            }
        }
    }

    private class TopicTitle implements TopicGroup {

        private String title;

        public TopicTitle(String title) {
            this.title = title;
        }

        @Override
        public Type getType() {
            return Type.TITLE;
        }

        public String getTitle() {
            return title;
        }
    }

    private class TopicPickupFeatureList implements TopicGroup {

        private List<PickupFeature> pickupFeatureList;

        public TopicPickupFeatureList(List<PickupFeature> pickupFeatureList) {
            this.pickupFeatureList = pickupFeatureList;
        }

        @Override
        public Type getType() {
            return Type.PICKUP_FEATURE;
        }

        public List<PickupFeature> getPickupFeatureList() {
            return pickupFeatureList;
        }
    }

    private class TopicFeatureList implements TopicGroup {

        private List<Feature> featureList;

        public TopicFeatureList(List<Feature> featureList) {
            this.featureList = featureList;
        }

        @Override
        public Type getType() {
            return Type.FEATURE;
        }

        public List<Feature> getFeatureList() {
            return featureList;
        }
    }
}

