package com.example.studentscaco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studentscaco.databinding.ActivityDetailActivitiesBinding;
import com.example.studentscaco.databinding.ActivityDetailTipsBinding;

public class DetailTipsActivity extends AppCompatActivity {

    ActivityDetailTipsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tips);
        binding = ActivityDetailTipsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.customToolbar.appToolbar.setTitle("Home");
        binding.customToolbar.appToolbar.setOnClickListener(view -> {
            finish();
        });
    }
}