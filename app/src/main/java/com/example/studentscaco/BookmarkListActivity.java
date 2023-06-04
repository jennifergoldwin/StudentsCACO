package com.example.studentscaco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.studentscaco.databinding.ActivityBookmarkListBinding;
import com.example.studentscaco.databinding.ActivityLoginBinding;
import com.example.studentscaco.utils.Data;
import com.example.studentscaco.utils.adapter.ListActivitiesAdapter;
import com.example.studentscaco.utils.model.Activities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BookmarkListActivity extends AppCompatActivity {

    private ActivityBookmarkListBinding binding;
    private ArrayList<Activities> activities = new ArrayList<>();
    private ListActivitiesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookmarkListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.customToolbar.appToolbar.setTitle("Bookmark");
        binding.customToolbar.appToolbar.setOnClickListener(view -> finish());

        try {
            fetchHttp();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        binding.rvListBookmark.setLayoutManager(new LinearLayoutManager(this));
    }

    void fetchHttp () throws JSONException {

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("dataSource", "Cluster0");
        jsonObject.put("database", "StudentCACO");
        jsonObject.put("collection", "Activities");
        JSONObject temp = new JSONObject();
        temp.put("bookmark",true);
        jsonObject.put("filter",temp);
        final String requestBody=jsonObject.toString();
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest
                jsonObjReq
                = new JsonObjectRequest(
                Request.Method.POST,
                Data.URL+"/action/find",
                null,

                response -> {
                    Iterator<String> iter = response.keys();
                    while (iter.hasNext()){{
                        String key = iter.next();
                        try {
                            JSONArray array = response.getJSONArray(key);
                            Log.v("RESPONSE",array.toString());
                            for (int i = 0 ; i < array.length() ; i++){
                                JSONObject object = array.getJSONObject(i);
                                Activities a = new Activities(object.getString("_id"),object.getString("date"),
                                        object.getString("desc"),
                                        object.getString("url"),object.getString("title"),object.getString("type"),object.getBoolean("bookmark"),object.getBoolean("apply"));
                                activities.add(a);
                                adapter = new ListActivitiesAdapter(this,activities,"Add");
                                binding.rvListBookmark.setAdapter(adapter);
                            }

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }}
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