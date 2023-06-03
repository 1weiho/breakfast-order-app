package com.fcu.breakfast_order_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DatabaseHandler {

    private AppCompatActivity activity;

    private SQLiteDatabase database;

    private static final String DATABASE_NAME = "breakfast.db";

    public static final String USER_TABLE = "CREATE TABLE IF NOT EXISTS user ( " +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "userName TEXT NOT NULL, " +
            "phone TEXT NOT NULL, " +
            "password TEXT NOT NULL)";

    public static final String CART_TABLE = "CREATE TABLE IF NOT EXISTS cart ( " +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "productName TEXT NOT NULL, " +
            "price Integer NOT NULL, " +
            "productImage Integer NOT NULL, " +
            "count Integer NOT NULL)";

    public static final String ORDER_TABLE = "CREATE TABLE IF NOT EXISTS orderRecord ( " +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "orderNumber Integer NOT NULL, " +
            "productName TEXT NOT NULL, " +
            "price Integer NOT NULL, " +
            "productImage Integer NOT NULL, " +
            "count Integer NOT NULL)";

    public DatabaseHandler(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void open() {
        database = activity.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
        database.execSQL(USER_TABLE);
        database.execSQL(CART_TABLE);
        database.execSQL(ORDER_TABLE);
    }

    public UserInfoClass login(String phone, String password) {
        Cursor cursor = database.rawQuery("SELECT * FROM user WHERE phone=? AND password=?", new String[]{phone, password});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return new UserInfoClass(cursor.getString(1), cursor.getString(2));
        } else {
            return null;
        }
    }

    public boolean register(String userName, String phone, String password) {
        ContentValues values = new ContentValues();
        values.put("userName", userName);
        values.put("phone", phone);
        values.put("password", password);
        try {
            database.insert("user", null, values);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addProductToCart(String productName, Integer price, Integer productImage, Integer count) {
        ContentValues values = new ContentValues();
        values.put("productName", productName);
        values.put("price", price);
        values.put("productImage", productImage);
        values.put("count", count);
        try {
            database.insert("cart", null, values);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getLatestOrderNumber() {
        Cursor cursor = database.rawQuery("SELECT * FROM orderRecord ORDER BY orderNumber DESC LIMIT 1", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getInt(1);
        } else {
            return 0;
        }
    }

    public void moveAllCartToOrder() {
        Cursor cursor = database.rawQuery("SELECT * FROM cart", null);
        if (cursor.moveToFirst()) {
            int orderNumber = getLatestOrderNumber() + 1;
            do {
                ContentValues values = new ContentValues();
                // check the latest order number and add 1
                values.put("orderNumber", orderNumber);
                values.put("productName", cursor.getString(1));
                values.put("price", cursor.getInt(2));
                values.put("productImage", cursor.getInt(3));
                values.put("count", cursor.getInt(4));
                database.insert("orderRecord", null, values);
            } while (cursor.moveToNext());
        }
        cursor.close();
        removeAllProductFromCart();
    }

    public OrderClass[] getAnOrder(int orderNumber) {
        Cursor cursor = database.rawQuery("SELECT * FROM orderRecord WHERE orderNumber=?", new String[]{String.valueOf(orderNumber)});
        OrderClass[] orderList = new OrderClass[cursor.getCount()];
        int i = 0;
        if (cursor.moveToFirst()) {
            do {
                OrderClass orderItem = new OrderClass(
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getInt(5)
                );
                orderList[i] = orderItem;
                i++;
            } while (cursor.moveToNext());
        }
        cursor.close();
        return orderList;
    }

    public int getOrderTotalPrice(int orderNumber) {
        Cursor cursor = database.rawQuery("SELECT SUM(price * count) AS totalPrice FROM orderRecord WHERE orderNumber=?", new String[]{String.valueOf(orderNumber)});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getInt(0);
        } else {
            return 0;
        }
    }


    // get all order number and it's total price
    public OrderNumberClass[] getOrderNumber() {
        Cursor cursor = database.rawQuery("SELECT orderNumber, SUM(count), SUM(price * count) AS totalPrice FROM orderRecord GROUP BY orderNumber", null);
        OrderNumberClass[] orderNumberList = new OrderNumberClass[cursor.getCount()];
        int i = 0;
        if (cursor.moveToFirst()) {
            do {
                OrderNumberClass orderNumberItem = new OrderNumberClass(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getInt(2)
                );
                orderNumberList[i] = orderNumberItem;
                i++;
            } while (cursor.moveToNext());
        }
        cursor.close();
        return orderNumberList;
    }

    public void removeProductFromCart(String productName) {
        database.delete("cart", "productName=?", new String[]{productName});
    }

    public void removeAllProductFromCart() {
        database.delete("cart", null, null);
    }

    public void updateProductCount(String productName, int countChange) {
        Cursor cursor = database.rawQuery("SELECT * FROM cart WHERE productName=?", new String[]{productName});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int count = cursor.getInt(4);
            ContentValues values = new ContentValues();
            values.put("count", count + countChange);
            database.update("cart", values, "productName=?", new String[]{productName});
        }
    }

    public ArrayList<CartClass> getCartProduct() {
        Cursor cursor = database.rawQuery("SELECT * FROM cart", null);
        ArrayList<CartClass> cartList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                CartClass cartItem = new CartClass(
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getInt(4)
                );
                cartList.add(cartItem);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return cartList;
    }


    public int getCartCount() {
        Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM cart", null);
        int count = 0;

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        return count;
    }

}