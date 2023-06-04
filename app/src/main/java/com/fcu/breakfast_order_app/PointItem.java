package com.fcu.breakfast_order_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PointItem extends LinearLayout {


    private TextView orderNumber;
    private TextView orderPoint;

    public PointItem(Context context) {
        super(context);
        init(context);
    }

    public PointItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PointItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.point_item, this);

        orderNumber = findViewById(R.id.orderNumber);
        orderPoint = findViewById(R.id.orderPoint);
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber.setText("訂單編號 #" + orderNumber);
    }

    public void setOrderPoint(int point) {
        this.orderPoint.setText("回饋" + point + "點");
    }


}
