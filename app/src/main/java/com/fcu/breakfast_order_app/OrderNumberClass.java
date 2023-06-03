package com.fcu.breakfast_order_app;

public class OrderNumberClass {


    int orderNumber;
    int count;
    int totalPrice;

    public OrderNumberClass(int orderNumber, int count, int totalPrice) {
        this.orderNumber = orderNumber;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
