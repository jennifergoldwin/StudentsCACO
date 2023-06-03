package com.example.studentscaco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studentscaco.databinding.ActivityBookmarkListBinding;
import com.example.studentscaco.databinding.ActivityLoginBinding;

public class BookmarkListActivity extends AppCompatActivity {

    ActivityBookmarkListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookmarkListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.customToolbar.appToolbar.setTitle("Bookmark");
        binding.customToolbar.appToolbar.setOnClickListener(view -> finish());
    }
}