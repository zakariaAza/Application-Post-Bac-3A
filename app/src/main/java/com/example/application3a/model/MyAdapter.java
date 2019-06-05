package com.example.application3a.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.application3a.controller.OnItemClickListener;
import com.example.application3a.R;

import java.util.List;

//Extend the RecyclerView.Adapter class//


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

    private List<Schools> dataList;
    private final OnItemClickListener listener;

    public MyAdapter(List<Schools> dataList, OnItemClickListener listener) {

        this.dataList = dataList;
        this.listener=listener;

    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

//Get a reference to the Views in our layout//

        public final View myView;

        TextView textUser;

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;

            textUser = myView.findViewById(R.id.user);

        }
    }

    @Override

//Construct a RecyclerView.ViewHolder//

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final Schools user = dataList.get(position);
        holder.textUser.setText(user.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(user);
            }
        });
    }

//Calculate the item count for the RecylerView//

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}