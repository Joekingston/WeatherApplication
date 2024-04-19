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

// Name: TomorrowAdapter
// Purpose: Adapter class for RecyclerView to display TomorrowSetting items
public class TomorrowAdapter extends RecyclerView.Adapter<TomorrowAdapter.ViewHolder> {
ArrayList<TomorrowSetting> items;
Context context;
    // Name: TomorrowAdapter constructor
    // Purpose: Initializes the adapter with the provided list of TomorrowSetting items
    // Params: items - ArrayList of TomorrowSetting objects
    public TomorrowAdapter(ArrayList<TomorrowSetting> items) {
        this.items = items;
    }
    // Name: ViewHolder
    // Purpose: ViewHolder class to hold references to views in RecyclerView items
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView dayTxt, statusTxt, highTxt, lowTxt;
        ImageView pic;
        // Name: ViewHolder constructor
        // Purpose: Initializes the ViewHolder with the views in the layout
        // Params: itemView - View representing a single item in the RecyclerView
        public ViewHolder(View itemView) {
            super(itemView);
            dayTxt=itemView.findViewById(R.id.dayTxt);
            statusTxt=itemView.findViewById(R.id.statusTxt);
            highTxt=itemView.findViewById(R.id.highTxt);
            lowTxt=itemView.findViewById(R.id.lowTxt);
            pic=itemView.findViewById(R.id.picRec);
        }
    }
    // Name: onCreateViewHolder
    // Purpose: Inflates the layout for a single item view and returns a new ViewHolder instance
    // Params: parent - The ViewGroup into which the new View will be added after it is bound to an adapter position
    //         viewType - The view type of the new View
    // Returns: A new ViewHolder instance
    @NonNull
    @Override
    public TomorrowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_tomorrow, parent, false);
        context = parent.getContext();
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Name: onBindViewHolder
    // Purpose: Binds data to views for each item in the RecyclerView
    // Params: holder - The ViewHolder which should be updated to represent the contents of the item at the given position
    //         position - The position of the item within the adapter's data set
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

    // Name: getItemCount
    // Purpose: Returns the total number of items in the data set held by the adapter
    // Returns: The total number of items in the data set
    @Override
    public int getItemCount() {

        return items.size();
    }
}
