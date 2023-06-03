package com.example.studentscaco.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.studentscaco.HomeActivity;
import com.example.studentscaco.R;
import com.example.studentscaco.databinding.ActivityLoginBinding;
import com.example.studentscaco.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {


    private ActivitySignUpBinding binding;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        binding.tvLogin.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), LoginActivity.class);
            startActivity(intent);
        });
    }
}