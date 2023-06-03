package com.fcu.breakfast_order_app;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ProductInfoActivity extends AppCompatActivity {

  public static final String EXTRA_PRODUCT_NAME = "extra_product_name";
  public static final String EXTRA_PRODUCT_PRICE = "extra_product_price";
  public static final String EXTRA_PRODUCT_IMAGE = "extra_product_image";

  private DatabaseHandler databaseHandler;

  private ProductPreview productPreview;
  private SectionTitle sectionTitle1;
  private SectionTitle sectionTitle2;
  private SectionTitle sectionTitle3;
  private CheckboxItem checkboxItem1;
  private CheckboxItem checkboxItem2;
  private CheckboxItem checkboxItem3;
  private CheckboxItem checkboxItem4;
  private CheckboxItem checkboxItem5;
  private CheckboxItem checkboxItem6;
  private ImageButton product_info_minus;
  private ImageButton product_info_plus;
  private TextView product_info_number;
  private LinearLayout addToCartBtn;
  private Nav nav;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    databaseHandler = new DatabaseHandler(this);
    databaseHandler.open();

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product_info);

    nav = findViewById(R.id.nav);

    Intent intent = getIntent();

    String productName = intent.getStringExtra(EXTRA_PRODUCT_NAME);
    int productPrice = intent.getIntExtra(EXTRA_PRODUCT_PRICE, 0);
    int productImage = intent.getIntExtra(EXTRA_PRODUCT_IMAGE, 0);

    productPreview = findViewById(R.id.preview);
    productPreview.setProductName(productName);
    productPreview.setProductPrice("NT " + productPrice);
    productPreview.setProductImage(productImage);

    sectionTitle1 = findViewById(R.id.se1);
    sectionTitle2 = findViewById(R.id.se2);
    sectionTitle3 = findViewById(R.id.se3);

    sectionTitle1.setSectionTitle("升級套餐");
    sectionTitle2.setSectionTitle("其他");
    sectionTitle3.setSectionTitle("備註");

    checkboxItem1 = findViewById(R.id.ch1);
    checkboxItem2 = findViewById(R.id.ch2);
    checkboxItem3 = findViewById(R.id.ch3);
    checkboxItem4 = findViewById(R.id.ch4);
    checkboxItem5 = findViewById(R.id.ch5);
    checkboxItem6 = findViewById(R.id.ch6);

    checkboxItem1.setCheckboxName("A餐（薯餅+中杯紅茶）+$39");
    checkboxItem2.setCheckboxName("B餐（薯條+中杯紅茶）+$39");
    checkboxItem3.setCheckboxName("C餐（雞塊+中杯紅茶）+$49");
    checkboxItem4.setCheckboxName("加蛋+$10");
    checkboxItem5.setCheckboxName("加起司+$15");
    checkboxItem6.setCheckboxName("去菜");

    product_info_number = findViewById(R.id.product_info_number);
    product_info_minus = findViewById(R.id.product_info_minus);
    product_info_plus = findViewById(R.id.product_info_plus);

    product_info_plus.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int count;
        count = parseInt(product_info_number.getText().toString());
        product_info_number.setText(Integer.toString(count + 1));
      }
    });

    product_info_minus.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int count;
        count = parseInt(product_info_number.getText().toString());
        if (count <= 0) {
          count = 0;
          product_info_number.setText(Integer.toString(count));
        } else {
          product_info_number.setText(Integer.toString(count - 1));
        }
      }
    });

    addToCartBtn = findViewById(R.id.addToCartBtn);
    addToCartBtn.setOnClickListener(v -> {
      if (databaseHandler.addProductToCart(productName, productPrice, productImage, parseInt((String) product_info_number.getText()))) {
        Toast.makeText(ProductInfoActivity.this, "加入購物車成功", Toast.LENGTH_SHORT).show();
        onBackPressed();
      } else {
        Toast.makeText(ProductInfoActivity.this, "加入購物車失敗", Toast.LENGTH_SHORT).show();
      }
    });

  }

    private void fetchCartCount() {
        databaseHandler = new DatabaseHandler(this);
        databaseHandler.open();

        int productCount = databaseHandler.getCartCount();
        nav.setCartCount(productCount);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchCartCount();
    }
}