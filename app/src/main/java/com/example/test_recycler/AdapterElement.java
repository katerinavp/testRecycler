package com.example.test_recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class AdapterElement extends ListAdapter<Element, AdapterElement.ViewHolder> {

    private final ElementRemoveClickListener elementRemoveClickListener;

    public AdapterElement(@NonNull DiffUtil.ItemCallback<Element> diffCallback, ElementRemoveClickListener elementRemoveClickListener) {
        super(diffCallback);
        this.elementRemoveClickListener = elementRemoveClickListener;
    }

    @NonNull
    @Override
    public AdapterElement.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.btnDelete.setOnClickListener(v -> elementRemoveClickListener.onRemoveClicked(holder.getAdapterPosition()));
        return holder;
    }

    @Override
    public void onBindViewHolder(AdapterElement.ViewHolder holder, int position) {
        Element element = getItem(position);
        holder.txtNumberElement.setText(String.valueOf(element.getNumber()));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNumberElement;
        Button btnDelete;

        ViewHolder(View view) {
            super(view);
            txtNumberElement = view.findViewById(R.id.txtNumberElement);
            btnDelete = view.findViewById(R.id.btnDelete);

        }
    }

}
