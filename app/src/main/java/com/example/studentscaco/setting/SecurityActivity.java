package com.example.studentscaco.setting;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.studentscaco.R;
import com.example.studentscaco.databinding.ActivitySecurityBinding;


public class SecurityActivity extends AppCompatActivity {

    private ActivitySecurityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);
        binding = ActivitySecurityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bindSecurity();

    }

    private void bindSecurity() {
        binding.llEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.llFormEmail.getVisibility() == View.GONE) {
                    binding.ivArrowEmail.setImageResource(R.drawable.angle_down);
                    binding.llFormEmail.setVisibility(View.VISIBLE);
                }
                else {
                    binding.ivArrowEmail.setImageResource(R.drawable.angle_right);
                    binding.llFormEmail.setVisibility(View.GONE);
                }
            }
        });

        binding.llPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.llFormPassword.getVisibility() == View.GONE) {
                    binding.ivArrowPassword.setImageResource(R.drawable.angle_down);
                    binding.llFormPassword.setVisibility(View.VISIBLE);
                }
                else {
                    binding.ivArrowPassword.setImageResource(R.drawable.angle_right);
                    binding.llFormPassword.setVisibility(View.GONE);
                }
            }
        });

    }
}