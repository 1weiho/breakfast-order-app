package com.fcu.breakfast_order_app;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

class Product {
  public String productName;
  public int productPrice;
  public int productNumber;
  public int productImage;

  public Product(String productName, int productPrice, int productNumber, int productImage) {
    this.productName = productName;
    this.productPrice = productPrice;
    this.productNumber = productNumber;
    this.productImage = productImage;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(int productPrice) {
    this.productPrice = productPrice;
  }

  public int getProductCount() {
    return productNumber;
  }

  public void setProductCount(int productNumber) {
    this.productNumber = productNumber;
  }

  public int getProductImage() {
    return productImage;
  }

  public void setProductImage(int productImage) {
    this.productImage = productImage;
  }
}

public class CartPageActivity extends AppCompatActivity {

  Product[] product = new Product[3];

  public int total = 0;

  private Head cart_headTitle;
  private BackButton cart_back_button;
  public TextView cart_total_price;
  private LinearLayout cart_linearLayout;


  public CartItem createCartItem(String cartName, Integer cartPrice, Integer cartImage, Integer cartNumber) {
    CartItem cartItem = new CartItem(this);
    cartItem.setLayoutParams(new LinearLayout.LayoutParams(
      LinearLayout.LayoutParams.MATCH_PARENT,
      LinearLayout.LayoutParams.WRAP_CONTENT
    ));
    cartItem.setCartName(cartName);
    cartItem.setCartPrice(cartPrice);
    cartItem.setCartImage(cartImage);
    cartItem.setCartNumber(cartNumber);

    return cartItem;
  }

  public void removeCartItem(View view) {
    cart_linearLayout.removeView(view);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cart_page);

    cart_linearLayout = findViewById(R.id.cart_linearlayout);

    product[0] = new Product("紫米時蔬嫩雞", 10, 10, R.drawable.food_img1);
    product[1] = new Product("紫米時蔬嫩雞1", 20, 10,R.drawable.food_img1);
    product[2] = new Product("紫米時蔬嫩雞2", 30, 10,R.drawable.food_img1);

    for (int i = 0; i < product.length; i++) {
      cart_linearLayout.addView(createCartItem(
              product[i].productName,
              product[i].productPrice,
              product[i].productImage,
              product[i].productNumber ));
    }

    for (int i = 0 ; i < product.length ; i++) {
      total = total + product[i].productPrice * product[i].productNumber;
    }

    cart_headTitle = findViewById(R.id.cart_headTitle);
    cart_headTitle.setHeadTitle("購物車");

    cart_back_button = findViewById(R.id.cart_back_button);
    cart_back_button.setLabel("繼續點餐");

    cart_total_price = findViewById(R.id.cart_total_price);
    cart_total_price.setText("總計:NT "+total);
  }
}