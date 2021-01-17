package com.example.test_recycler;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class ElementDiffItemCallback extends DiffUtil.ItemCallback<Element> {
    @Override
    public boolean areItemsTheSame(@NonNull Element oldItem, @NonNull Element newItem) {
        return oldItem.number == newItem.number;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Element oldItem, @NonNull Element newItem) {
        return true;
    }
}

