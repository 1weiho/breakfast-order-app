package com.fcu.breakfast_order_app;

public class OrderClass extends CartClass {

    private int orderNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderClass(int orderNumber, String productName, int price, int productImage, int count) {
        super(productName, price, productImage, count);
        setOrderNumber(orderNumber);
    }
}
