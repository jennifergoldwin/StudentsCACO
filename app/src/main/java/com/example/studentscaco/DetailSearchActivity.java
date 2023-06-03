package com.example.studentscaco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.studentscaco.databinding.ActivityDetailSearchBinding;
import com.example.studentscaco.databinding.ActivityLoginBinding;

public class DetailSearchActivity extends AppCompatActivity {

    ActivityDetailSearchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.customToolbar.appToolbar.setTitle(getIntent().getStringExtra("title"));
        binding.customToolbar.appToolbar.setOnClickListener(view -> finish());
        binding.ivBookmark.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(),BookmarkListActivity.class));
        });
    }
}