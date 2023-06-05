package com.example.studentscaco.utils.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.studentscaco.DetailActivitiesActivity;
import com.example.studentscaco.R;
import com.example.studentscaco.utils.Data;
import com.example.studentscaco.utils.model.Activities;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ListActivitiesAdapter extends RecyclerView.Adapter<ListActivitiesAdapter.ViewHolder>{

    private Context ctx;
    private int count=0;
    private String titleButton ;
    private ArrayList<Activities> activities;


    public ListActivitiesAdapter(Context ctx, ArrayList<Activities> activities, String titleButton ) {
        this.ctx = ctx;
        this.activities = activities;
        this.titleButton = titleButton;
    }


    @NonNull
    @Override
    public ListActivitiesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_organization_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListActivitiesAdapter.ViewHolder holder, int position) {
        updateStatusBookmark(position,holder);

        holder.bookmark.setOnClickListener(view -> {
            try {
                updateHttp(activities.get(position).get_id(), !activities.get(position).getBookmark(), position,holder);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        });

        holder.btn.setText(titleButton);
        holder.title.setText(activities.get(position).getTitle());
        holder.date.setText("Deadline "+activities.get(position).getDate());
        Picasso.get().load(activities.get(position).getUrl()).into(holder.imageView);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivitiesActivity.class);
            intent.putExtra("title",activities.get(position).getTitle());
            intent.putExtra("date",activities.get(position).getDate());
            intent.putExtra("desc",activities.get(position).getDesc());
            intent.putExtra("url",activities.get(position).getUrl());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    void updateStatusBookmark(int position,ListActivitiesAdapter.ViewHolder holder){
        if (activities.get(position).getBookmark()){
            holder.bookmark.setImageResource(R.drawable.bookmark_filled);
        }else{
            holder.bookmark.setImageResource(R.drawable.bookmark);
        }
    }
    @Override
    public int getItemCount() {

        return activities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView bookmark;
        TextView title;
        TextView date;
        Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_org_img);
            title = itemView.findViewById(R.id.tv_item_org_title);
            date = itemView.findViewById(R.id.tv_item_org_date);
            bookmark = itemView.findViewById(R.id.ib_bookmark);
            btn = itemView.findViewById(R.id.btn_add);
        }
    }
    void updateHttp (String id, Boolean status,int pos,ListActivitiesAdapter.ViewHolder holder) throws JSONException {

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("dataSource", "Cluster0");
        jsonObject.put("database", "StudentCACO");
        jsonObject.put("collection", "Activities");

        JSONObject temp = new JSONObject();
        temp.put("_id",id);
        jsonObject.put("filter",temp);

        JSONObject up1Data = new JSONObject();
        up1Data.put("bookmark",status);
        JSONObject up1 = new JSONObject();
        up1.put("$set",up1Data);
        jsonObject.put("update",up1);

        final String requestBody=jsonObject.toString();
        RequestQueue queue = Volley.newRequestQueue(ctx);
        JsonObjectRequest
                jsonObjReq
                = new JsonObjectRequest(
                Request.Method.POST,
                Data.URL+"/action/updateOne",
                null,

                response -> {
                    updateStatusBookmark(pos,holder);
                },
                error -> {

                }) {

            @Override
            public Map getHeaders() throws AuthFailureError
            {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/json");
                headers.put("apiKey", "IlwIMqNn8VMPezXd38cVK5HAUirwZDlaeGsbokIe9TAyaHzIgxDqsaVhwrf4xULt");
                return headers;
            }

            @Override
            public byte[] getBody() {
                try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }
        };
        queue.add(jsonObjReq);
    }
}
