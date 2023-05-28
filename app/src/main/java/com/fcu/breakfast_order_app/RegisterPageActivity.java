package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPageActivity extends AppCompatActivity {

    private Head head;
    private EditText phone;
    private EditText password;
    private Button registerButton;
    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        head = findViewById(R.id.headtitle);
        head.setHeadTitle("註冊");

        phone = findViewById(R.id.editTextPhone);
        password = findViewById(R.id.editTextPassword);
        registerButton = findViewById(R.id.submitButton);
        registerButton.setOnClickListener(v -> {
            databaseHandler = new DatabaseHandler(this);
            databaseHandler.open();
            if (databaseHandler.register(phone.getText().toString(), password.getText().toString())) {
                Toast.makeText(this, "註冊成功", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegisterPageActivity.this, LoginPageActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "註冊失敗", Toast.LENGTH_SHORT).show();
            }

        });
    }
}