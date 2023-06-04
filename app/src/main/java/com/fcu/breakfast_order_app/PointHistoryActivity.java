package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class PointHistoryActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private Head head;
    private Nav nav;
    private LinearLayout orderList;
    private BackButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_history);

        head = findViewById(R.id.headTitle);
        head.setHeadTitle("點數紀錄");

        nav = findViewById(R.id.nav);
        orderList = findViewById(R.id.pointList);

        databaseHandler = new DatabaseHandler(this);
        databaseHandler.open();

        PointRecordClass[] pointRecordClasses = databaseHandler.getPointRecord();
        for (int i = 0; i < pointRecordClasses.length; i++) {
            orderList.addView(createPointItem(pointRecordClasses[i].getOrderNumber(), pointRecordClasses[i].getPointCount()));
        }

        backBtn = findViewById(R.id.backBtn);
        backBtn.setLabel("上一步");
        backBtn.setOnClickListener(v -> onBackPressed());
    }

    private PointItem createPointItem(int orderNumber, int pointCount) {
        PointItem pointItem = new PointItem(this);
        pointItem.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        pointItem.setOrderNumber(orderNumber);
        pointItem.setOrderPoint(pointCount);
        return pointItem;
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