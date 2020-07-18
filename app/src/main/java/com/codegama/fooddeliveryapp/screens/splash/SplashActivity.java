package com.codegama.fooddeliveryapp.screens.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.codegama.fooddeliveryapp.R;
import com.codegama.fooddeliveryapp.screens.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {
    Handler handler;
    private static final long delayTime = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        }, delayTime);
    }
}