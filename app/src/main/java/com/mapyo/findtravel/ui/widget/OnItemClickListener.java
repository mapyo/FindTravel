package com.mapyo.findtravel.ui.widget;

import android.support.annotation.NonNull;
import android.view.View;

public interface OnItemClickListener<T> {

    void onItemClick(@NonNull View view, T item);

}

