package com.mapyo.findtravel.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class TopicListFragment extends Fragment {
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
