package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MemberInfoActivity extends AppCompatActivity {
    private DatabaseHandler databaseHandler;
    private Head head;
    private Nav nav;

    private UserInfoCard userInfoCard;

    private ButtonWithIcon currentOrderButton;
    private ButtonWithIcon historyOrderButton;
    private ButtonWithIcon historyPointButton;
    private ButtonWithIcon resetPasswordButton;
    private ButtonWithIcon logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info);

        // Set head title
        head = findViewById(R.id.headTitle);
        head.setHeadTitle("會員資訊");

        nav = findViewById(R.id.nav);

        // Set user information
        SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        String userName = sharedPref.getString("userName", "");
        String phone = sharedPref.getString("phone", "");
        userInfoCard = findViewById(R.id.userInfo);
        userInfoCard.setUserName(userName);
        userInfoCard.setUserProfileImage(R.drawable.profile_image);
        userInfoCard.setUserPhone(phone);
        userInfoCard.setPointCount(37);

        // Set buttons
        currentOrderButton = findViewById(R.id.currentOrderButton);
        historyOrderButton = findViewById(R.id.historyOrderButton);
        historyPointButton = findViewById(R.id.historyPointButton);
        resetPasswordButton = findViewById(R.id.resetPasswordButton);
        logoutButton = findViewById(R.id.logoutButton);

        // Set buttons with icon and text
        currentOrderButton.setButtonWithIcon("當前訂單", R.drawable.current_order_btn_icon);
        historyOrderButton.setButtonWithIcon("歷史訂單", R.drawable.history_order_btn_icon);
        historyPointButton.setButtonWithIcon("點數紀錄", R.drawable.point_btn_icon);
        resetPasswordButton.setButtonWithIcon("變更密碼", R.drawable.password_btn_icon);
        logoutButton.setButtonWithIcon("登出", R.drawable.logout_btn_icon);

        logoutButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("is_logged_in", false);
            editor.remove("phone");
            editor.apply();

            Intent intent = new Intent(MemberInfoActivity.this, ProductBrowseActivity.class);
            startActivity(intent);
        });

        historyOrderButton.setOnClickListener(v -> {
            Intent intent = new Intent(MemberInfoActivity.this, OrderHistoryActivity.class);
            startActivity(intent);
        });
    }

    private void fetchCartCount() {
        databaseHandler = new DatabaseHandler(this);
        databaseHandler.open();

        int productCount = databaseHandler.getCartCount();
        nav.setCartCount(productCount);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchCartCount();
    }
}