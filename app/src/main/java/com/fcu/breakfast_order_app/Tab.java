package com.fcu.breakfast_order_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Tab extends RelativeLayout {
    private Button tabButton;

    public Tab(Context context) {
        super(context);
        init(context);
    }

    public Tab(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Tab(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.tab, this);

        tabButton = findViewById(R.id.tabButton);
    }

    public void setTabButton(String buttonName) {
        tabButton.setText(buttonName);
    }
}
