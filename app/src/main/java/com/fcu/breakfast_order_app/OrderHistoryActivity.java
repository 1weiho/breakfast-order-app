package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class OrderHistoryActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private Head head;
    private Nav nav;
    private LinearLayout orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        head = findViewById(R.id.headTitle);
        head.setHeadTitle("歷史訂單");

        nav = findViewById(R.id.nav);
        orderList = findViewById(R.id.orderList);

        OrderItem orderItem = new OrderItem(this);
        orderItem.setOrderNumber(1);
        orderItem.setOrderDesc(5, 100);
        orderItem.setOrderPoint(3);

        orderList.addView(orderItem);
    }

}