package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CartItem extends LinearLayout {

  private ImageView cartItemImage;
  private TextView cartItemName;
  private TextView cartItemPrice;
  private ImageButton cartItemMinus;
  private TextView cartItemNumber;
  private ImageButton cartItemPlus;
  private ImageView cartItemIcon;
  private TextView cartItemDelete;

  public CartItem(Context context) {
    super(context);
    init(context);
  }

  public CartItem(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public CartItem(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init(context);
  }

  private void init(Context context) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.product_card, this);

    cartItemImage = findViewById(R.id.cartItem_image);
    cartItemName = findViewById(R.id.cartItem_name);
    cartItemPrice = findViewById(R.id.cartItem_price);
    cartItemMinus = findViewById(R.id.cartItem_minus);
    cartItemNumber = findViewById(R.id.cartItem_number);
    cartItemPlus = findViewById(R.id.cartItem_plus);
    cartItemIcon = findViewById(R.id.cartItem_icon);
    cartItemDelete = findViewById(R.id.cartItem_delete);
  }
}