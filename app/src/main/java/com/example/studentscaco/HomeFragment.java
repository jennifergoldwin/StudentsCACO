package com.example.studentscaco;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studentscaco.databinding.FragmentHomeBinding;
import com.example.studentscaco.setting.SettingActivity;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.itemLayoutTips.btnReadItemTips.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(), DetailTipsActivity.class));
        });
        binding.itemLayoutScholarship.btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailActivitiesActivity.class);
            startActivity(intent);
        });
        binding.itemLayoutRecommendation.btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailActivitiesActivity.class);
            startActivity(intent);
        });
        binding.ivBookmark.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(), BookmarkListActivity.class));
        });
        binding.ivSettings.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(), SettingActivity.class));
        });
        binding.tvSeeAllTips.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(), DetailTipsActivity.class));
        });
        binding.tvSeeAllRecommendation.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailSearchActivity.class);
            intent.putExtra("title","Recommendation");
            startActivity(intent);
        });
        binding.tvSeeAllScholarship.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailSearchActivity.class);
            intent.putExtra("title","Scholarship");
            startActivity(intent);
        });

        return binding.getRoot();
    }
}