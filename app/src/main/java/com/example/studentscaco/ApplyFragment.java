package com.example.studentscaco;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.studentscaco.databinding.FragmentApplyBinding;
import com.example.studentscaco.databinding.FragmentSearchBinding;
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

public class ApplyFragment extends Fragment {

    private FragmentApplyBinding binding;
    private ArrayList<Activities> activities = new ArrayList<>();
    private ListActivitiesAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentApplyBinding.inflate(inflater, container, false);
        try {
            fetchHttp();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        binding.ibBookmark.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(),BookmarkListActivity.class));
        });
        binding.rvFragmentApplyListApply.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }
    void fetchHttp () throws JSONException {

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("dataSource", "Cluster0");
        jsonObject.put("database", "StudentCACO");
        jsonObject.put("collection", "Activities");
        JSONObject temp = new JSONObject();
        temp.put("apply",true);
        jsonObject.put("filter",temp);
        final String requestBody=jsonObject.toString();
        RequestQueue queue = Volley.newRequestQueue(getContext());
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
                                adapter = new ListActivitiesAdapter(getContext(),activities,"Apply");
                                binding.rvFragmentApplyListApply.setAdapter(adapter);
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