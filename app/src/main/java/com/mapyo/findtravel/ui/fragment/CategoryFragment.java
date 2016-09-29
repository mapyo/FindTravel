package com.mapyo.findtravel.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mapyo.findtravel.R;

public class CategoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        return view;
    }

    public static class Builder {
        private Bundle mArgs;

        public Builder() {
            mArgs = new Bundle();
        }

        public Fragment build() {
            CategoryFragment fragment = new CategoryFragment();
            fragment.setArguments(mArgs);
            return fragment;
        }
    }
}
