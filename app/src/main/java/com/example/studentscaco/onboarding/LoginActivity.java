package com.example.studentscaco.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.studentscaco.HomeActivity;
import com.example.studentscaco.R;
import com.example.studentscaco.databinding.ActivityLoginBinding;
import com.example.studentscaco.databinding.ActivityMainBinding;
import com.example.studentscaco.utils.Data;
import com.example.studentscaco.utils.adapter.ListActivitiesAdapter;
import com.example.studentscaco.utils.model.Activities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvActivitySignUp.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(), SignUpActivity.class));
        });
        binding.btnActivityLogin.setOnClickListener(view -> {
            String username = binding.etUsername.getText().toString();
            String password = binding.etPassword.getText().toString();
            if (username.isEmpty()||password.isEmpty()){
                Toast.makeText(this,"Username or password can't be empty",Toast.LENGTH_SHORT).show();
            }else{
                try {
                    fetchHttp(username,password);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
//            startActivity(new Intent(view.getContext(), SplashScreen2.class));
        });
    }

    void fetchHttp (String username,String password) throws JSONException {

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("dataSource", "Cluster0");
        jsonObject.put("database", "StudentCACO");
        jsonObject.put("collection", "User");
        JSONObject temp = new JSONObject();
        temp.put("username",username);
        temp.put("password",password);
        jsonObject.put("filter",temp);
        final String requestBody=jsonObject.toString();
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest
                jsonObjReq
                = new JsonObjectRequest(
                Request.Method.POST,
                Data.URL+"/action/findOne",
                null,

                response -> {
                    Iterator<String> iter = response.keys();
                    while (iter.hasNext()){
                        String key = iter.next();
                        Log.v("RESPONSE",key);
                        JSONObject object = null;
                        try {
                            object = response.getJSONObject(key);
                            startActivity(new Intent(this, HomeActivity.class));
                        } catch (JSONException e) {
                            Toast.makeText(this,"Username or password invalid",Toast.LENGTH_SHORT).show();
                        }

                    }

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