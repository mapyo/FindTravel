package com.mapyo.findtravel.ui.widget;

import android.support.annotation.NonNull;
import android.view.View;

public interface OnItemLongClickListener<T> {

    boolean onItemLongClick(@NonNull View view, T item);

}

