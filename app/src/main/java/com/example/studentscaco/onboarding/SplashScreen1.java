package com.example.studentscaco.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.studentscaco.R;

import org.bson.Document;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;
import io.realm.mongodb.sync.SyncConfiguration;

public class SplashScreen1 extends AppCompatActivity {

//    Realm uiThreadRealm;
//    MongoClient mongoClient;
//    MongoDatabase mongoDatabase;
//    MongoCollection<Document> mongoCollection;
//    User user;
//


    String realmName = "StudentCACO";
    RealmConfiguration config;

    Realm backgroundThreadRealm;
    App app;
    String AppId = "application-student-caco-xafgc";


    void checkCurrentUser(){
        if (app.currentUser() == null) {
            app.loginAsync(Credentials.anonymous(), new App.Callback<User>() {
                @Override
                public void onResult(App.Result<User> result) {
                    if (result.isSuccess()) {
                        Log.e("gagal","2");
                        initDB();
                    } else {
                        Log.e("gagal","1");
                        Toast.makeText(getApplicationContext(), "Failed to login", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Log.e("gagal","3");
            initDB();
        }
    }
    void initDB(){
        config = new RealmConfiguration.Builder().name(realmName).build();
        backgroundThreadRealm = Realm.getInstance(config);
        SyncConfiguration config = new SyncConfiguration.Builder(app.currentUser(),"")
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();

        Realm.getInstanceAsync(config, new Realm.Callback() {
            @Override
            public void onSuccess(Realm realm) {
                Log.v(
                        "EXAMPLE",
                        "Successfully opened a realm with reads and writes allowed on the UI thread."
                );
            }
        });
//        new Handler().postDelayed(new Runnable() {
//
//
//            @Override
//            public void run() {
//                // This method will be executed once the timer is over
//                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
//                startActivity(i);
//                finish();
//            }
//        }, 2000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen1);
        Realm.init(this);
        app = new App(new AppConfiguration.Builder(AppId).build());
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
//        checkCurrentUser();
    }
}