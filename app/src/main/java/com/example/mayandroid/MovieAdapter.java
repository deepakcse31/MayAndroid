package com.example.mayandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    List<Search> listdata;
    public MovieAdapter(List<Search> listdata) {

        this.listdata = listdata;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.rv_list_item, parent, false);
        MovieAdapter.ViewHolder viewHolder = new MovieAdapter.ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(listdata.get(position).getTitle());
        holder.tvDesc.setText(listdata.get(position).getImdbID());
        Glide.with(holder.itemView.getContext()).load(listdata.get(position).getPoster()).into(holder.ivimg);
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

