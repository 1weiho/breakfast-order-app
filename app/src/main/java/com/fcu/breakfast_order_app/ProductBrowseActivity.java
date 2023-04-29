package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProductBrowseActivity extends AppCompatActivity {

    public Head head;
    public Tab tab1;
    public Tab tab2;
    public Tab tab3;
    public Tab tab4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_browse);

        head = findViewById(R.id.headTitle);
        head.setHeadTitle("麥味登");

        tab1 = findViewById(R.id.tab1);
        tab1.setTabButton("特選餐點");
        tab1.setActivated(true);
        tab2 = findViewById(R.id.tab2);
        tab2.setTabButton("中西餐點");
        tab2.setActivated(false);
        tab3 = findViewById(R.id.tab3);
        tab3.setTabButton("漢堡湯種");
        tab3.setActivated(false);
        tab4 = findViewById(R.id.tab4);
        tab4.setTabButton("經典麵包");
        tab4.setActivated(false);

    }
}