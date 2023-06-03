package com.fcu.breakfast_order_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrderItem extends LinearLayout {


    private TextView orderNumber;
    private TextView orderDesc;
    private TextView orderPoint;

    public OrderItem(Context context) {
        super(context);
        init(context);
    }

    public OrderItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public OrderItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.order_item, this);

        orderNumber = findViewById(R.id.orderNumber);
        orderDesc = findViewById(R.id.orderDesc);
        orderPoint = findViewById(R.id.orderPoint);
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber.setText(orderNumber);
    }

    public void setOrderDesc(int count, int price) {
        this.orderDesc.setText(count + "份品項，" + price);
    }

    public void setOrderPoint(int point) {
        this.orderPoint.setText("獲得" + point + "點");
    }


}
