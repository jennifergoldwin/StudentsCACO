package com.example.studentscaco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);
        homeFragment = new HomeFragment();

        bottomNavigationView
                .setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (R.id.home == item.getItemId()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, new HomeFragment())
                    .commit();
            return true;
        }
        if (R.id.search == item.getItemId()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, new SearchFragment())
                    .commit();
            return true;
        }
        if (R.id.apply == item.getItemId()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, new ApplyFragment())
                    .commit();
            return true;
        }
        if (R.id.profile == item.getItemId()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, new ProfileFragment())
                    .commit();
            return true;
        }
        return false;

    }
}