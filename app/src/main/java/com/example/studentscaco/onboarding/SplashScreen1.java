package com.example.studentscaco.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.studentscaco.R;

public class SplashScreen1 extends AppCompatActivity {

    void moveLayout(){
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen1);
//        Realm.init(this);
//        app = new App(new AppConfiguration.Builder(AppId).build());
//        checkCurrentUser();
        moveLayout();
    }

}