package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TomorrowAdapter extends RecyclerView.Adapter<TomorrowAdapter.ViewHolder> {
ArrayList<TomorrowSetting> items;
Context context;
    public TomorrowAdapter(ArrayList<TomorrowSetting> items) {
        this.items = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView dayTxt, statusTxt, highTxt, lowTxt;
        ImageView pic;

        public ViewHolder(View itemView) {
            super(itemView);
            dayTxt=itemView.findViewById(R.id.dayTxt);
            statusTxt=itemView.findViewById(R.id.statusTxt);
            highTxt=itemView.findViewById(R.id.highTxt);
            lowTxt=itemView.findViewById(R.id.lowTxt);
            pic=itemView.findViewById(R.id.picRec);
        }
    }

    @NonNull
    @Override
    public TomorrowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_tomorrow, parent, false);
        context = parent.getContext();
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull TomorrowAdapter.ViewHolder holder, int position) {

    holder.dayTxt.setText(items.get(position).getDay());
    holder.statusTxt.setText(items.get(position).getStatus());
    holder.highTxt.setText(items.get(position).getHighTemp()+"°");
    holder.lowTxt.setText(items.get(position).getLowTemp()+"°");

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
