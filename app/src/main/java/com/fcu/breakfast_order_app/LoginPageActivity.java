package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LoginPageActivity extends AppCompatActivity {

    private Head head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        head = findViewById(R.id.headtitle);
        head.setHeadTitle("登入");

    }
}