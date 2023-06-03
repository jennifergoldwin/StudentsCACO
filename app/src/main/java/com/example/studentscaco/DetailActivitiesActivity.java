package com.example.studentscaco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studentscaco.databinding.ActivityDetailActivitiesBinding;
import com.example.studentscaco.databinding.ActivityLoginBinding;

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

    }
}