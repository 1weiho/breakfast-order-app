package com.fcu.breakfast_order_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SectionTitle extends LinearLayout {
    private TextView sectionTitle;

    public SectionTitle(Context context) {
        super(context);
        init(context);
    }

    public SectionTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SectionTitle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.section_title, this);

        sectionTitle = findViewById(R.id.sectionTitle);
    }


    public void setSectionTitle(String title) {
        sectionTitle.setText(title);
    }

}
