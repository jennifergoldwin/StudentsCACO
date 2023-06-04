package com.example.studentscaco.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.studentscaco.R;
//import com.example.studentscaco.utils.Data;

//import org.bson.Document;

//import io.realm.Realm;
//import io.realm.RealmConfiguration;
//import io.realm.mongodb.App;
//import io.realm.mongodb.AppConfiguration;
//import io.realm.mongodb.Credentials;
//import io.realm.mongodb.User;
//import io.realm.mongodb.mongo.MongoClient;
//import io.realm.mongodb.mongo.MongoCollection;
//import io.realm.mongodb.mongo.MongoDatabase;
//import io.realm.mongodb.sync.SyncConfiguration;


public class SplashScreen1 extends AppCompatActivity {

    String URL = "https://ap-southeast-1.aws.data.mongodb-api.com/app/data-eqcuk/endpoint/data/v1";
//    RealmConfiguration config;
    String AppId = "application-student-caco-xafgc";


    void checkCurrentUser(){
//        if (app.currentUser() == null) {
//
//            app.loginAsync(Credentials.anonymous(), new App.Callback<User>() {
//                @Override
//                public void onResult(App.Result<User> result) {
//                    if (result.isSuccess()) {
//                        Data.user = app.currentUser();
//                        Data.mongoClient = app.currentUser().getMongoClient("mongodb-atlas");
//                        Data.mongoDatabase = Data.mongoClient.getDatabase("StudentCACO");
//
//                        moveLayout();
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Failed to login", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        } else {
//            Data.user = app.currentUser();
//            Data.mongoClient = app.currentUser().getMongoClient("mongodb-atlas");
//            Data.mongoDatabase = Data.mongoClient.getDatabase("StudentCACO");
//            moveLayout();
//        }
    }
    void moveLayout(){
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
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