package com.fcu.breakfast_order_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

public class BackButton extends LinearLayout {
  private Button backButton;

  public BackButton(Context context) {
    super(context);
    init(context);
  }

  public BackButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public BackButton(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init(context);
  }

  private void init(Context context) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.back_button, this);

    backButton = findViewById(R.id.backButton);

  }

  public void setLabel(String name) {
    backButton.setText(name);
  }
}