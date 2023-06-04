package com.example.studentscaco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.studentscaco.databinding.ActivityDetailActivitiesBinding;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class DetailActivitiesActivity extends AppCompatActivity {

    private ActivityDetailActivitiesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailActivitiesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.customToolbar.appToolbar.setTitle("Kembali");
        binding.customToolbar.appToolbar.setOnClickListener(view -> {
            finish();
        });
        Intent intent = getIntent();
        binding.tvActivityDetailActTitleText.setText(intent.getStringExtra("title"));
        binding.tvActivityDetailActDescText.setText(intent.getStringExtra("desc"));
        binding.tvActivityDetailActDeadlineText.setText("Deadline: "+intent.getStringExtra("date"));
        Picasso.get().load(intent.getStringExtra("url")).resize(50, 50)
                .centerCrop().into(binding.ivActivityDetailActImg);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}