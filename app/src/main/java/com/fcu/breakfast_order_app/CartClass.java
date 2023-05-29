package com.fcu.breakfast_order_app;

public class CartClass {

  private String productName;
  private int price;
  private int productImage;
  private int count;

  public CartClass(String productName, int price, int productImage, int count) {
    this.productName = productName;
    this.price = price;
    this.productImage = productImage;
    this.count = count;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getProductImage() {
    return productImage;
  }

  public void setProductImage(int productImage) {
    this.productImage = productImage;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
