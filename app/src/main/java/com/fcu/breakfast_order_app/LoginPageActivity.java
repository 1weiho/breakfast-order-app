package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
            if (databaseHandler.login(phone.getText().toString(), password.getText().toString())) {
                Toast.makeText(this, "登入成功", Toast.LENGTH_SHORT).show();
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