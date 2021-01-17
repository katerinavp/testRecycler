package com.example.test_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class AdapterElement extends RecyclerView.Adapter<AdapterElement.ViewHolder> {

    ElementViewModel model;
    // private final LayoutInflater inflater;
    private final List<Element> list;
//
//    public AdapterElement(Context context, List<Element> list) {
//        this.list = list;
//        this.inflater = LayoutInflater.from(context);
//
//    }

    public AdapterElement(List<Element> list) {
        this.list = list;


    }

    @Override
    public AdapterElement.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterElement.ViewHolder holder, int position) {
        Element element = list.get(position);
        TextView textNumber = holder.txtNumberElement.findViewById(R.id.txtNumberElement);
        textNumber.setText(String.valueOf(element.getNumber()));
        Button btnDelete = holder.btnDelete.findViewById(R.id.btnDelete);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //deleteItemByPosition(position);//i is your adapter position
                list.remove(position);
                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
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


    public List<Element> deleteItemByPosition(int position) {
        list.remove(position);
        notifyDataSetChanged();
        //  model.setData(list);
        return list;
    }

    public List<Element> getList() {
        return list;
    }
}
