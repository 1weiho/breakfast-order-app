package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPageActivity extends AppCompatActivity {

    private Head head;
    private EditText phone;
    private EditText password;
    private Button registerButton;
    private DatabaseHandler databaseHandler;
    private Button navToRegBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        head = findViewById(R.id.headtitle);
        head.setHeadTitle("登入");

        phone = findViewById(R.id.editTextPhone);
        password = findViewById(R.id.editTextPassword);
        registerButton = findViewById(R.id.submitButton);
        registerButton.setOnClickListener(v -> {
            databaseHandler = new DatabaseHandler(this);
            databaseHandler.open();
            UserInfoClass userInfo = databaseHandler.login(phone.getText().toString(), password.getText().toString());
            if (userInfo != null) {
                Toast.makeText(this, "登入成功", Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("is_logged_in", true);
                editor.putString("userName", userInfo.getUserName());
                editor.putString("phone", userInfo.getPhone());
                editor.apply();
                Intent intent = new Intent(LoginPageActivity.this, ProductBrowseActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "登入失敗", Toast.LENGTH_SHORT).show();
            }
        });
        navToRegBtn = findViewById(R.id.navToRegBtn);
            navToRegBtn.setOnClickListener(v -> {
                Intent intent = new Intent(LoginPageActivity.this, RegisterPageActivity.class);
                startActivity(intent);
            });

    }
}