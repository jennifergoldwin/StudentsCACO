package com.example.studentscaco.utils.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentscaco.DetailActivitiesActivity;
import com.example.studentscaco.R;
import com.example.studentscaco.utils.model.Activities;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListActivitiesAdapter extends RecyclerView.Adapter<ListActivitiesAdapter.ViewHolder>{

    private Context ctx;
    private int count=0;
    private ArrayList<Activities> activities;


    public ListActivitiesAdapter(Context ctx, ArrayList<Activities> activities ) {
        this.ctx = ctx;
        this.activities = activities;
        Log.v("YESSS", String.valueOf(this.activities.size()));
    }


    @NonNull
    @Override
    public ListActivitiesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_organization_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListActivitiesAdapter.ViewHolder holder, int position) {


        holder.title.setText(activities.get(position).getTitle());
        holder.date.setText("Deadline "+activities.get(position).getDate());
        Picasso.get().load(activities.get(position).getUrl()).resize(100, 100)
                .centerCrop().into(holder.imageView);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivitiesActivity.class);
            intent.putExtra("title",activities.get(position).getTitle());
            intent.putExtra("date",activities.get(position).getDate());
            intent.putExtra("desc",activities.get(position).getDesc());
            intent.putExtra("url",activities.get(position).getUrl());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {

        return activities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_org_img);
            title = itemView.findViewById(R.id.tv_item_org_title);
            date = itemView.findViewById(R.id.tv_item_org_date);
        }
    }
}
