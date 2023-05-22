package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class ProductBrowseActivity extends AppCompatActivity {

  private Head head;
  private Tab tab1;
  private Tab tab2;
  private Tab tab3;
  private Tab tab4;
  private LinearLayout productList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product_browse);

    head = findViewById(R.id.headTitle);
    head.setHeadTitle("麥味登");

    tab1 = findViewById(R.id.tab1);
    tab1.setTabButton("特選餐點");
    tab1.setActivated(true);
    tab2 = findViewById(R.id.tab2);
    tab2.setTabButton("中西餐點");
    tab2.setActivated(false);
    tab3 = findViewById(R.id.tab3);
    tab3.setTabButton("漢堡湯種");
    tab3.setActivated(false);
    tab4 = findViewById(R.id.tab4);
    tab4.setTabButton("經典麵包");
    tab4.setActivated(false);

    productList = findViewById(R.id.productList);

    ProductCard[] productCards = new ProductCard[9];

    for (int i = 0; i < productCards.length; i++) {
      productCards[i] = new ProductCard(this);
      productCards[i].setLayoutParams(new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
      ));
    }

    productCards[0].setProductName("紫米時蔬嫩雞飯");
    productCards[0].setProductPrice(120);
    productCards[0].setProductImage(R.drawable.food_img1);
    productCards[1].setProductName("茄汁原塊嫩雞飯");
    productCards[1].setProductPrice(130);
    productCards[1].setProductImage(R.drawable.food_img2);
    productCards[2].setProductName("唐揚雞咖哩烏龍麵");
    productCards[2].setProductPrice(140);
    productCards[2].setProductImage(R.drawable.food_img3);
    productCards[3].setProductName("原塊嫩雞咖哩烏龍麵");
    productCards[3].setProductPrice(130);
    productCards[3].setProductImage(R.drawable.food_img4);
    productCards[4].setProductName("蘑菇鐵板麵");
    productCards[4].setProductPrice(40);
    productCards[4].setProductImage(R.drawable.food_img5);
    productCards[5].setProductName("黑胡椒鐵板麵");
    productCards[5].setProductPrice(40);
    productCards[5].setProductImage(R.drawable.food_img6);
    productCards[6].setProductName("眷村麻辣鐵板麵");
    productCards[6].setProductPrice(60);
    productCards[6].setProductImage(R.drawable.food_img7);
    productCards[7].setProductName("川味麻辣鐵板麵");
    productCards[7].setProductPrice(70);
    productCards[7].setProductImage(R.drawable.food_img8);
    productCards[8].setProductName("優蛋白蛋捲餐");
    productCards[8].setProductPrice(90);
    productCards[8].setProductImage(R.drawable.food_img9);

    for (ProductCard productCard : productCards) {
      productList.addView(productCard);
    }
  }
}