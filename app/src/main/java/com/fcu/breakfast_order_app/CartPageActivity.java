package com.fcu.breakfast_order_app;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CartPageActivity extends AppCompatActivity {

  private int total = 0;

  private LinearLayout cart_linearlayout;
  private Head cart_headTitle;
  private BackButton cart_back_button;
  private TextView cart_total_price;
  private LinearLayout cart_linearLayout;
  private ImageButton cartItemMinus;
  private ImageButton cartItemPlus;
  private TextView cartItemNumber;

  private CartItem createCartItem(String cartName, Integer cartPrice, Integer cartImage) {
    CartItem cartItem = new CartItem(this);
    cartItem.setLayoutParams(new LinearLayout.LayoutParams(
      LinearLayout.LayoutParams.MATCH_PARENT,
      LinearLayout.LayoutParams.WRAP_CONTENT
    ));
    cartItem.setCartName(cartName);
    cartItem.setCartPrice(cartPrice);
    cartItem.setCartImage(cartImage);

    cartItemMinus = findViewById(R.id.cartItem_minus);
    cartItemPlus = findViewById(R.id.cartItem_plus);
    cartItemNumber = findViewById(R.id.cartItem_number);
//    cart_price = findViewById(R.id.cart_price);

//    cartItemPlus.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        total = total + cartItem.getCartPrice();
//        cart_price.setText("總計:NT "+total);
//      }
//    });
//
//    cartItemMinus.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        total = total + cartItem.getCartPrice();
//        cart_price.setText("總計:NT "+total);
//      }
//    });

//    total = total + cartItem.getCartPrice();

    return cartItem;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cart_page);

    cart_linearLayout = findViewById(R.id.cart_linearlayout);

    //CartItem cart[] = new CartItem[30];

    cart_linearLayout.addView(createCartItem("紫米時蔬嫩雞飯",100,R.drawable.food_img1));
    cart_linearLayout.addView(createCartItem("黑狗套餐",100,R.drawable.food_img1));
//    cart_linearLayout.addView(createCartItem("熱狗香蕉套餐",120,R.drawable.food_img1));
//    cart_linearLayout.addView(createCartItem("國軍敬禮套餐",100,R.drawable.food_img1));
//    cart_linearLayout.addView(createCartItem("國軍敬禮套餐",130,R.drawable.food_img1));
//    cart_linearLayout.addView(createCartItem("國軍敬禮套餐",100,R.drawable.food_img1));
//    cart_linearLayout.addView(createCartItem("紫米時蔬嫩雞飯",130,R.drawable.food_img1));

    cart_headTitle = findViewById(R.id.cart_headTitle);
    cart_headTitle.setHeadTitle("購物車");

    cart_back_button = findViewById(R.id.cart_back_button);
    cart_back_button.setLabel("繼續點餐");

//    cart_total_price = findViewById(R.id.cart_total_price);
//    cart_total_price.setText("總計:NT "+total);
  }
}