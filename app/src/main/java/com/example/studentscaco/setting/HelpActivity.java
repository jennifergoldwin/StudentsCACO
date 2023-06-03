package com.example.studentscaco.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.studentscaco.R;
import com.example.studentscaco.databinding.ActivityApperanceBinding;
import com.example.studentscaco.databinding.ActivityHelpBinding;

public class HelpActivity extends AppCompatActivity {

    private ActivityHelpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHelpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bindHelp();
        binding.tbCustom.appToolbar.setOnClickListener(view -> finish());
    }

    private void bindHelp() {
        binding.llTitleHelp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.tvDescHelp1.getVisibility() == View.GONE) {
                    binding.ivArrowHelp1.setImageResource(R.drawable.angle_down);
                    binding.tvDescHelp1.setVisibility(View.VISIBLE);
                }
                else {
                    binding.ivArrowHelp1.setImageResource(R.drawable.angle_right);
                    binding.tvDescHelp1.setVisibility(View.GONE);
                }
            }
        });

        binding.llTitleHelp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.tvDescHelp2.getVisibility() == View.GONE) {
                    binding.ivArrowHelp2.setImageResource(R.drawable.angle_down);
                    binding.tvDescHelp2.setVisibility(View.VISIBLE);
                }
                else {
                    binding.ivArrowHelp2.setImageResource(R.drawable.angle_right);
                    binding.tvDescHelp2.setVisibility(View.GONE);
                }
            }
        });

        binding.llTitleHelp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.tvDescHelp3.getVisibility() == View.GONE) {
                    binding.ivArrowHelp3.setImageResource(R.drawable.angle_down);
                    binding.tvDescHelp3.setVisibility(View.VISIBLE);
                }
                else {
                    binding.ivArrowHelp3.setImageResource(R.drawable.angle_right);
                    binding.tvDescHelp3.setVisibility(View.GONE);
                }
            }
        });
    }
}