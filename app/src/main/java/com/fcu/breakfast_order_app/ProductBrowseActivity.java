package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ProductBrowseActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private Head head;
    private Nav nav;
    private Tab tab1;
    private Tab tab2;
    private Tab tab3;
    private Tab tab4;
    private LinearLayout productList;

    private void showItemsForTab(int tabNumber) {
        productList.removeAllViews();

        switch (tabNumber) {
            case 1:
                productList.addView(createProductCard("紫米時蔬嫩雞飯", 120, R.drawable.food_img1));
                productList.addView(createProductCard("茄汁原塊嫩雞飯", 130, R.drawable.food_img2));
                productList.addView(createProductCard("唐揚雞咖哩烏龍麵", 140, R.drawable.food_img3));
                productList.addView(createProductCard("原塊嫩雞咖哩烏龍麵", 130, R.drawable.food_img4));
                productList.addView(createProductCard("蘑菇鐵板麵", 40, R.drawable.food_img5));
                productList.addView(createProductCard("黑胡椒鐵板麵", 40, R.drawable.food_img6));
                productList.addView(createProductCard("眷村麻辣鐵板麵", 60, R.drawable.food_img7));
                productList.addView(createProductCard("川味麻辣鐵板麵", 70, R.drawable.food_img8));
                productList.addView(createProductCard("優蛋白蛋捲餐", 90, R.drawable.food_img9));
                break;
            case 2:
                productList.addView(createProductCard("嫩煎腿排", 70, R.drawable.food_img10));
                productList.addView(createProductCard("菜脯蛋", 30, R.drawable.food_img11));
                productList.addView(createProductCard("椒麻雞塊(5塊)", 50, R.drawable.food_img12));
                productList.addView(createProductCard("時蔬嫩蛋", 30, R.drawable.food_img13));
                productList.addView(createProductCard("香檸雞柳條(3條)", 60, R.drawable.food_img14));
                productList.addView(createProductCard("法國吐司", 35, R.drawable.food_img15));
                productList.addView(createProductCard("燻雞握蛋捲餅", 55, R.drawable.food_img16));
                productList.addView(createProductCard("鮪魚握蛋捲餅", 55, R.drawable.food_img17));
                productList.addView(createProductCard("豬排握蛋捲餅", 55, R.drawable.food_img18));
                break;
            case 3:
                productList.addView(createProductCard("鮮蔬湯種", 40, R.drawable.food_img19));
                productList.addView(createProductCard("歐姆蛋湯種", 45, R.drawable.food_img20));
                productList.addView(createProductCard("超厚雞肉起司湯種", 65, R.drawable.food_img21));
                productList.addView(createProductCard("超厚蔬肉湯種", 60, R.drawable.food_img22));
                productList.addView(createProductCard("原塊魚排湯種", 60, R.drawable.food_img23));
                productList.addView(createProductCard("檸檬雞堡", 65, R.drawable.food_img24));
                productList.addView(createProductCard("鮮蔬堡", 45, R.drawable.food_img25));
                productList.addView(createProductCard("鮮蛋沙拉堡", 50, R.drawable.food_img26));
                productList.addView(createProductCard("歐姆蛋漢堡", 45, R.drawable.food_img27));
                break;
            case 4:
                productList.addView(createProductCard("鮪魚蛋滿分堡", 55, R.drawable.food_img28));
                productList.addView(createProductCard("超厚雞肉起司滿分堡", 60, R.drawable.food_img29));
                productList.addView(createProductCard("超厚蔬肉起司滿分堡", 60, R.drawable.food_img30));
                productList.addView(createProductCard("港式豬肉滿分蛋堡", 55, R.drawable.food_img31));
                productList.addView(createProductCard("原塊魚排蛋滿分堡", 55, R.drawable.food_img32));
                productList.addView(createProductCard("草莓丹麥", 40, R.drawable.food_img33));
                productList.addView(createProductCard("燻雞可頌", 55, R.drawable.food_img34));
                productList.addView(createProductCard("檸檬雞可頌", 55, R.drawable.food_img35));
                productList.addView(createProductCard("鮮蔬可頌", 45, R.drawable.food_img36));
                break;
        }
    }

    private ProductCard createProductCard(String productName, Integer productPrice, Integer productImage) {
        ProductCard productCard = new ProductCard(this);
        productCard.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        productCard.setProductName(productName);
        productCard.setProductPrice(productPrice);
        productCard.setProductImage(productImage);

        productCard.setOnClickListener(view -> {
            Intent intent = new Intent(ProductBrowseActivity.this, ProductInfoActivity.class);
            intent.putExtra(ProductInfoActivity.EXTRA_PRODUCT_NAME, productName);
            intent.putExtra(ProductInfoActivity.EXTRA_PRODUCT_PRICE, productPrice);
            intent.putExtra(ProductInfoActivity.EXTRA_PRODUCT_IMAGE, productImage);
            startActivity(intent);
        });

        return productCard;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_browse);

        head = findViewById(R.id.headTitle);
        head.setHeadTitle("麥味登");

        nav = findViewById(R.id.nav);
        databaseHandler = new DatabaseHandler(this);
        databaseHandler.open();
        int productCount = databaseHandler.getCartCount();
        nav.setCartCount(productCount);

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
        showItemsForTab(1);


        tab1.setOnTabClickListener(view -> {
            tab1.setActivated(true);
            tab2.setActivated(false);
            tab3.setActivated(false);
            tab4.setActivated(false);
            showItemsForTab(1);

        });

        tab2.setOnTabClickListener(view -> {
            tab1.setActivated(false);
            tab2.setActivated(true);
            tab3.setActivated(false);
            tab4.setActivated(false);
            showItemsForTab(2);
        });

        tab3.setOnTabClickListener(view -> {
            tab1.setActivated(false);
            tab2.setActivated(false);
            tab3.setActivated(true);
            tab4.setActivated(false);
            showItemsForTab(3);
        });

        tab4.setOnTabClickListener(view -> {
            tab1.setActivated(false);
            tab2.setActivated(false);
            tab3.setActivated(false);
            tab4.setActivated(true);
            showItemsForTab(4);
        });
    }
}