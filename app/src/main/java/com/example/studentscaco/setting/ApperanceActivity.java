package com.example.studentscaco.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studentscaco.R;
import com.example.studentscaco.databinding.ActivityApperanceBinding;
import com.example.studentscaco.databinding.ActivitySecurityBinding;

public class ApperanceActivity extends AppCompatActivity {

    ActivityApperanceBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityApperanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tbCustom.appToolbar.setOnClickListener(view -> finish());
    }
}