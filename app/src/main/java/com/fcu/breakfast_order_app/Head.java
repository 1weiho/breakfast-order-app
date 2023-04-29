package com.fcu.breakfast_order_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Head extends LinearLayout {

    private TextView headTitle;

    public Head(Context context) {
        super(context);
        init(context);
    }

    public Head(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Head(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.head, this);

        headTitle = findViewById(R.id.headText);
    }

    public void setHeadTitle(String title) {
        headTitle.setText(title);
    }
}
