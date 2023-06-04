package com.fcu.breakfast_order_app;

public class PointRecordClass {

    int pointCount;
    int orderNumber;

    public PointRecordClass(int pointCount, int orderNumber) {
        this.pointCount = pointCount;
        this.orderNumber = orderNumber;
    }

    public int getPointCount() {
        return pointCount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
