package com.example.studentscaco.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.studentscaco.R;
import com.example.studentscaco.databinding.ActivityApperanceBinding;
import com.example.studentscaco.databinding.ActivitySettingBinding;
import com.example.studentscaco.databinding.LogoutBottomsheetLayoutBinding;
import com.example.studentscaco.onboarding.SplashScreen1;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SettingActivity extends AppCompatActivity {

    private ActivitySettingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bindSetting();
        binding.tbCustom.appToolbar.setOnClickListener(view -> finish());
    }

    private void bindSetting() {
        binding.llSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, SecurityActivity.class);
                startActivity(intent);
            }
        });

        binding.llAppearance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ApperanceActivity.class);
                startActivity(intent);
            }
        });

        binding.llHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });

        binding.llLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog logoutBottomSheet = new BottomSheetDialog(SettingActivity.this);
                logoutBottomSheet.setContentView(R.layout.logout_bottomsheet_layout);
                logoutBottomSheet.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button cancel = logoutBottomSheet.findViewById(R.id.bt_cancel);
                Button logout = logoutBottomSheet.findViewById(R.id.bt_logout);

                logoutBottomSheet.show();

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        logoutBottomSheet.dismiss();
                    }
                });
                logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SettingActivity.this, SplashScreen1.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
        });
    }
}