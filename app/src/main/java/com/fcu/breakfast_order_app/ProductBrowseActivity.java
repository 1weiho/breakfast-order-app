package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProductBrowseActivity extends AppCompatActivity {

    private Head head;
    private Tab tab1;
    private Tab tab2;
    private Tab tab3;
    private Tab tab4;
    private ProductCard productCard1;
    private ProductCard productCard2;
    private ProductCard productCard3;
    private ProductCard productCard4;
    private ProductCard productCard5;
    private ProductCard productCard6;
    private ProductCard productCard7;
    private ProductCard productCard8;
    private ProductCard productCard9;

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

        productCard1 = findViewById(R.id.productCard1);
        productCard1.setProductName("紫米時蔬嫩雞飯");
        productCard1.setProductPrice("NT 120");
        productCard1.setProductImage(R.drawable.food_img1);
        productCard2 = findViewById(R.id.productCard2);
        productCard2.setProductName("茄汁原塊嫩雞飯");
        productCard2.setProductPrice("NT 130");
        productCard2.setProductImage(R.drawable.food_img2);
        productCard3 = findViewById(R.id.productCard3);
        productCard3.setProductName("唐揚雞咖哩烏龍麵");
        productCard3.setProductPrice("NT 140");
        productCard3.setProductImage(R.drawable.food_img3);
        productCard4 = findViewById(R.id.productCard4);
        productCard4.setProductName("原塊嫩雞咖哩烏龍麵");
        productCard4.setProductPrice("NT 130");
        productCard4.setProductImage(R.drawable.food_img4);
        productCard5 = findViewById(R.id.productCard5);
        productCard5.setProductName("蘑菇鐵板麵");
        productCard5.setProductPrice("NT 40");
        productCard5.setProductImage(R.drawable.food_img5);
        productCard6 = findViewById(R.id.productCard6);
        productCard6.setProductName("黑胡椒鐵板麵");
        productCard6.setProductPrice("NT 40");
        productCard6.setProductImage(R.drawable.food_img6);
        productCard7 = findViewById(R.id.productCard7);
        productCard7.setProductName("眷村麻辣鐵板麵");
        productCard7.setProductPrice("NT 60");
        productCard7.setProductImage(R.drawable.food_img7);
        productCard8 = findViewById(R.id.productCard8);
        productCard8.setProductName("川味麻辣鐵板麵");
        productCard8.setProductPrice("NT 70");
        productCard8.setProductImage(R.drawable.food_img8);
        productCard9 = findViewById(R.id.productCard9);
        productCard9.setProductName("優蛋白蛋捲餐");
        productCard9.setProductPrice("NT 90");
        productCard9.setProductImage(R.drawable.food_img9);

    }
}