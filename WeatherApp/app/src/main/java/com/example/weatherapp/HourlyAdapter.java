package com.example.weatherapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.ViewHolder> {
ArrayList<Hourly> items;
Context context;
    public HourlyAdapter(ArrayList<Hourly> items) {
        this.items = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView hour, temp;
        ImageView pic;

        public ViewHolder(View itemView) {
            super(itemView);
            hour=itemView.findViewById(R.id.hourTxt);
            temp=itemView.findViewById(R.id.tempTxt);
            pic=itemView.findViewById(R.id.hourlypic);
        }
    }

    @NonNull
    @Override
    public HourlyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_hourly, parent, false);
        context = parent.getContext();
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.ViewHolder holder, int position) {
        holder.hour.setText(items.get(position).getHour());
        holder.temp.setText(items.get(position).getTemp()+"°");

        int drawableResourceId=holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);
    }


    @Override
    public int getItemCount() {

        return items.size();
    }
}
