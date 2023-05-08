package com.fcu.breakfast_order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProductInfo extends AppCompatActivity {

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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.product_info);

    productPreview = findViewById(R.id.preview);
    productPreview.setProductName("紫米時蔬嫩雞飯");
    productPreview.setProductPrice("NT 120");
    productPreview.setProductImage(R.drawable.food_img);


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




  }
}