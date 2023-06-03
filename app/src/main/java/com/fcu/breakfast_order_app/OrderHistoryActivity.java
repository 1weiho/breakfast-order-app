package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        databaseHandler = new DatabaseHandler(this);
        databaseHandler.open();

        OrderNumberClass[] orderNumberClasses = databaseHandler.getOrderNumber();
        for (int i = 0; i < orderNumberClasses.length; i++) {
            orderList.addView(createOrderItem(orderNumberClasses[i].getOrderNumber(), orderNumberClasses[i].getCount(), orderNumberClasses[i].getTotalPrice()));
        }
    }

    private OrderItem createOrderItem(int number, int count, int price) {
        OrderItem orderItem = new OrderItem(this);
        orderItem.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        orderItem.setOrderNumber(number);
        orderItem.setOrderDesc(count, price);
        orderItem.setOrderPoint(price / 10);
        orderItem.setOnClickListener(v -> {
            Intent intent = new Intent(this, OrderDetailActivity.class);
            intent.putExtra(OrderDetailActivity.EXTRA_ORDER_NUMBER, number);
            startActivity(intent);
        });

        return orderItem;
    }

}