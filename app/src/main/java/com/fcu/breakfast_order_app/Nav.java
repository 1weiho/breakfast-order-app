package com.fcu.breakfast_order_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Nav extends RelativeLayout {

    private ImageButton menuButton;
    private TextView cartCount;
    private ImageButton cartBtn;

    public Nav(Context context) {
        super(context);
        init(context);
    }

    public Nav(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Nav(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.nav, this);

        menuButton = findViewById(R.id.menuBtn);
        cartBtn = findViewById(R.id.cartBtn);

        menuButton.setOnClickListener(v -> {
            SharedPreferences sharedPref = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
            boolean isLoggedIn = sharedPref.getBoolean("is_logged_in", false);
            Intent intent;
            if (isLoggedIn) {
                intent = new Intent(context, MemberInfoActivity.class);
            } else {
                intent = new Intent(context, LoginPageActivity.class);
            }
            context.startActivity(intent);
        });

        cartBtn.setOnClickListener(v -> {
            SharedPreferences sharedPref = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
            boolean isLoggedIn = sharedPref.getBoolean("is_logged_in", false);
            Intent intent;
            if (isLoggedIn) {
                intent = new Intent(context, CartPageActivity.class);
            } else {
                intent = new Intent(context, LoginPageActivity.class);
            }
            context.startActivity(intent);
        });
    }

    public void setCartCount(int count) {
        cartCount = findViewById(R.id.cartCount);
        cartCount.setText(String.valueOf(count));
    }

}
