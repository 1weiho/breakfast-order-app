package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
public class LargeButton extends LinearLayout {
    private Button largeButton;

    public LargeButton(Context context) {
        super(context);
        init(context);
    }

    public LargeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LargeButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.large_button, this);

        largeButton = findViewById(R.id.largeButton);

    }

    public void setLargeButton(String title) {
        largeButton.setText(title);
    }

}