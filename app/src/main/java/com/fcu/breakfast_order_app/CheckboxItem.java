package com.fcu.breakfast_order_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class CheckboxItem extends LinearLayout {
  private CheckBox checkboxName;

  public CheckboxItem(Context context) {
    super(context);
    init(context);
  }

  public CheckboxItem(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public CheckboxItem(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init(context);
  }

  private void init(Context context) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.checkbox_item, this);

    checkboxName = findViewById(R.id.checkbox_name);

  }

  public void setCheckboxName(String name) {
    checkboxName.setText(name);
  }
}