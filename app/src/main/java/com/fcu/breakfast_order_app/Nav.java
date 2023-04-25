package com.fcu.breakfast_order_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Nav extends RelativeLayout {

    public Nav(Context context) {
        super(context);
        init(context);
    }

    public Nav(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Nav(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.nav, this);
    }

}
