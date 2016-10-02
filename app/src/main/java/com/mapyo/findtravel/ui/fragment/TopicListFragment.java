package com.mapyo.findtravel.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mapyo.findtravel.R;
import com.mapyo.findtravel.contract.TopicListContract;
import com.mapyo.findtravel.databinding.FragmentTopicListBinding;
import com.mapyo.findtravel.model.entity.Feature;
import com.mapyo.findtravel.model.entity.PickupFeature;
import com.mapyo.findtravel.presenter.TopicListPresenter;

import java.util.List;

public class TopicListFragment extends Fragment implements TopicListContract.View {
    private FragmentTopicListBinding binding;
    private TopicListPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTopicListBinding.inflate(inflater, container, false);

        // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
        presenter = new TopicListPresenter(this, getContext());
        presenter.fetchTopic();

        return binding.getRoot();
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), R.string.failed_fetch_article, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPickupFeatures(List<PickupFeature> pickupFeatures) {
        binding.fragmentPickupFeatureListView.addPickupFeatures(pickupFeatures);
    }

    @Override
    public void showFeatures(List<Feature> features) {
        binding.fragmentFeatureListView.addFeatures(features);
    }

    public static class Builder {
        private Bundle args;

        public Builder() {
            args = new Bundle();
        }

        public Fragment build() {
            TopicListFragment fragment = new TopicListFragment();
            fragment.setArguments(args);
            return fragment;
        }
    }
}
