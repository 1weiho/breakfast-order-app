package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CartPageActivity extends AppCompatActivity {

  private LinearLayout cart_linearlayout;
  private Head cart_headTitle;
  private CartItem cartItem1;
  private CartItem cartItem2;
  private CartItem cartItem3;
  private CartItem cartItem4;
  private CartItem cartItem5;
  private CartItem cartItem6;
  private BackButton cart_back_button;
  private TextView cart_price;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cart_page);

    cart_linearlayout = findViewById(R.id.cart_linearlayout);
    cart_headTitle = findViewById(R.id.cart_headTitle);
    cartItem1 = findViewById(R.id.cartItem1);
    cartItem2 = findViewById(R.id.cartItem2);
    cartItem3 = findViewById(R.id.cartItem3);
    cartItem4 = findViewById(R.id.cartItem4);
    cartItem5 = findViewById(R.id.cartItem5);
    cartItem6 = findViewById(R.id.cartItem6);
    cart_back_button = findViewById(R.id.cart_back_button);
    cart_price = findViewById(R.id.cart_price);

    cart_headTitle.setHeadTitle("購物車");

//    cartItem1.setCartName("紫米時蔬嫩雞飯");
//    cartItem1.setCartPrice("NT 100");
//    cartItem1.setCartImage(R.drawable.food_img1);
//
//    cartItem2.setCartName("黑狗套餐");
//    cartItem2.setCartPrice("NT 110");
//    cartItem2.setCartImage(R.drawable.food_img1);
//
//    cartItem3.setCartName("熱狗香蕉套餐");
//    cartItem3.setCartPrice("NT 120");
//    cartItem3.setCartImage(R.drawable.food_img1);
//
//    cartItem4.setCartName("國軍敬禮套餐");
//    cartItem4.setCartPrice("NT 130");
//    cartItem4.setCartImage(R.drawable.food_img1);
//
//    cartItem5.setCartName("國軍敬禮套餐");
//    cartItem5.setCartPrice("NT 130");
//    cartItem5.setCartImage(R.drawable.food_img1);
//
//    cartItem6.setCartName("國軍敬禮套餐");
//    cartItem6.setCartPrice("NT 130");
//    cartItem6.setCartImage(R.drawable.food_img1);

    cart_back_button.setLabel("繼續點餐");

    int sum = 0;
    cart_price.setText("總計:NT "+sum);
  }
}