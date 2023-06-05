package com.example.studentscaco;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studentscaco.databinding.FragmentApplyBinding;
import com.example.studentscaco.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        binding.btnEditProfile.setOnClickListener(view -> {
            setStatus(true);
            binding.btnSave.setVisibility(View.VISIBLE);
            binding.btnCancel.setVisibility(View.VISIBLE);
            binding.btnEditProfile.setVisibility(View.GONE);
        });
        binding.btnSave.setOnClickListener(view -> {
            setStatus(false);
            binding.btnSave.setVisibility(View.GONE);
            binding.btnCancel.setVisibility(View.GONE);
            binding.btnEditProfile.setVisibility(View.VISIBLE);
        });
        binding.btnCancel.setOnClickListener(view -> {
            setStatus(false);
            binding.btnSave.setVisibility(View.GONE);
            binding.btnCancel.setVisibility(View.GONE);
            binding.btnEditProfile.setVisibility(View.VISIBLE);
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    void setStatus(boolean status){
        binding.etJurusan.setEnabled(status);
        binding.etEmail.setEnabled(status);
        binding.etFullName.setEnabled(status);
        binding.etNIM.setEnabled(status);
        binding.etUsername.setEnabled(status);

    }
}