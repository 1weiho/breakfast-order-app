package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class OrderDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ORDER_NUMBER = "extra_order_number";
    private DatabaseHandler databaseHandler;
    private LinearLayout productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        productList = findViewById(R.id.productList);

        Intent intent = getIntent();
        int orderNumber = intent.getIntExtra(EXTRA_ORDER_NUMBER, -1);

        databaseHandler = new DatabaseHandler(this);
        databaseHandler.open();

        OrderClass[] orderDetailItems = databaseHandler.getAnOrder(orderNumber);

        for (int i = 0; i < orderDetailItems.length; i++) {
            productList.addView(createOrderDetailCard(orderDetailItems[i].getProductName(), orderDetailItems[i].getPrice(), orderDetailItems[i].getCount()));
        }
    }

    private OrderDetailCard createOrderDetailCard(String productName, int productPrice, int productCount) {
        OrderDetailCard orderDetailCard = new OrderDetailCard(this);
        orderDetailCard.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        orderDetailCard.setProductName(productName, productCount);
        orderDetailCard.setProductPrice(productPrice);

        return orderDetailCard;
    }
}