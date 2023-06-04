package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordActivity extends AppCompatActivity {

    private Head headTitle;
    private EditText oldPassword;
    private EditText newPassword;
    private EditText newPasswordConfirm;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        headTitle = findViewById(R.id.headTitle);
        oldPassword = findViewById(R.id.oldPassword);
        newPassword = findViewById(R.id.newPassword);
        newPasswordConfirm = findViewById(R.id.newPasswordConfirm);
        submitButton = findViewById(R.id.submitButton);

        headTitle.setHeadTitle("變更密碼");

        submitButton.setOnClickListener(v -> {
            if (handleResetPassword(oldPassword.getText().toString(), newPassword.getText().toString(), newPasswordConfirm.getText().toString())) {
                Toast.makeText(this, "密碼變更成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private boolean handleResetPassword(String oldPassword, String newPassword, String newPasswordConfirm) {
        if (oldPassword.isEmpty() || newPassword.isEmpty() || newPasswordConfirm.isEmpty()) {
            Toast.makeText(this, "請輸入完整資訊", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!newPassword.equals(newPasswordConfirm)) {
            Toast.makeText(this, "新密碼與確認密碼不相符", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            DatabaseHandler databaseHandler = new DatabaseHandler(this);
            databaseHandler.open();
            SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
            String userName = sharedPref.getString("userName", "");

            if (databaseHandler.resetPassword(userName, oldPassword, newPassword)) {
                return true;
            } else {
                Toast.makeText(this, "舊密碼錯誤", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

    }
}