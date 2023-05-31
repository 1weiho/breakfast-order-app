package com.fcu.breakfast_order_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DatabaseHandler {

    private AppCompatActivity activity;

    private SQLiteDatabase database;

    private static final String DATABASE_NAME = "breakfast.db";

    private static final String CREATE_MEAL_TABLE = "CREATE TABLE IF NOT EXISTS Meals ( " +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT NOT NULL, " +
            "description TEXT, " +
            "price Integer NOT NULL)";

    public static final String USER_TABLE = "CREATE TABLE IF NOT EXISTS user ( " +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "userName TEXT NOT NULL, " +
            "phone TEXT NOT NULL, " +
            "password TEXT NOT NULL)";

    public DatabaseHandler(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void open() {
        database = activity.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
//        database.execSQL(CREATE_MEAL_TABLE);
        database.execSQL(USER_TABLE);
    }

    public UserInfo login(String phone, String password) {
        Cursor cursor = database.rawQuery("SELECT * FROM user WHERE phone=? AND password=?", new String[]{phone, password});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return new UserInfo(cursor.getString(1), cursor.getString(2));
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

    public void addMeal(String name, String description, int price) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("description", description);
        values.put("price", price);
        database.insert("Meals", null, values);
    }

    public void deleteMeal(int id) {
        database.delete("Meals", "_id=?", new String[]{String.valueOf(id)});
    }

    public Cursor getAllMeals() {
        Cursor cursor = database.rawQuery("SELECT * FROM Meals", null);
        Toast.makeText(activity, cursor.getCount() + " is added", Toast.LENGTH_SHORT).show();

        return cursor;
    }

}