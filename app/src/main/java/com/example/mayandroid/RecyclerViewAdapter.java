package com.example.mayandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
     List<MyListData> listdata;
    public RecyclerViewAdapter(List<MyListData> listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.rv_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(listdata.get(position).getName());
        holder.tvDesc.setText(listdata.get(position).getDesc());
       // holder.ivimg.setImageResource(listdata.get(position).getImageid());

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivimg;
        public TextView tvName;
        public TextView tvDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivimg=itemView.findViewById(R.id.ivimg);
            tvName=itemView.findViewById(R.id.tvName);
            tvDesc=itemView.findViewById(R.id.tvDesc);
        }
    }
}
