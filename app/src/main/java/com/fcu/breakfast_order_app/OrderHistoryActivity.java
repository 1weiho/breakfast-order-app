package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class OrderHistoryActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private Head head;
    private Nav nav;
//    private LinearLayout orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        head = findViewById(R.id.headTitle);
        head.setHeadTitle("會員資訊");

        nav = findViewById(R.id.nav);
//        orderList = findViewById(R.id.orderList);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

//        orderList.addView(createOrderItem(new OrderNumberClass(1, 2, 3)));

    }

//    private OrderItem createOrderItem(OrderNumberClass orderNumberClass) {
//        OrderItem orderItem = new OrderItem(this);
//        orderItem.setOrderNumber(orderNumberClass.getOrderNumber());
//        orderItem.setOrderDesc(orderNumberClass.getCount(), orderNumberClass.getTotalPrice());
//        orderItem.setOrderPoint(orderNumberClass.getTotalPrice() / 10);
//        return orderItem;
//    }
}