package com.codegama.fooddeliveryapp.screens.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.codegama.fooddeliveryapp.R;
import com.codegama.fooddeliveryapp.screens.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {
    private AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), HomeActivity.class));
                finish();
            }
        });
    }
}