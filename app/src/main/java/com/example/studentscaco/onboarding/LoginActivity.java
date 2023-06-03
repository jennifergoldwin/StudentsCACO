package com.example.studentscaco.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.studentscaco.HomeActivity;
import com.example.studentscaco.R;
import com.example.studentscaco.databinding.ActivityLoginBinding;
import com.example.studentscaco.databinding.ActivityMainBinding;

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
            startActivity(new Intent(view.getContext(), SplashScreen2.class));
        });
    }
}