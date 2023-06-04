package com.example.studentscaco;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studentscaco.databinding.FragmentHomeBinding;
import com.example.studentscaco.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment {
    private FragmentSearchBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        binding.rlScholarship.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailSearchActivity.class);
            intent.putExtra("title","Scholarship");
            startActivity(intent);
        });
        binding.rlCommittee.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailSearchActivity.class);
            intent.putExtra("title","Committee");
            startActivity(intent);
        });
        binding.rlInternship.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailSearchActivity.class);
            intent.putExtra("title","Internship");
            startActivity(intent);
        });
        binding.rlOrg.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailSearchActivity.class);
            intent.putExtra("title","Organization");
            startActivity(intent);
        });
        binding.rlVolunteer.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailSearchActivity.class);
            intent.putExtra("title","Volunteer");
            startActivity(intent);
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}