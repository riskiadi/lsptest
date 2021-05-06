package com.alkalynx.tugaslsp.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.alkalynx.tugaslsp.model.MenuModel;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHelper extends SQLiteOpenHelper {


    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "pemesanan.db";

    public static String TABLE_NAME = "pemesanan";

    public static String CUSTOMER_COLUMN_ID = "id";
    public static String CUSTOMER_COLUMN_NAME = "name";
    public static String CUSTOMER_COLUMN_MENU = "menu";
    public static String CUSTOMER_COLUMN_LAT = "lat";
    public static String CUSTOMER_COLUMN_LONG = "lng";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                " (" + CUSTOMER_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CUSTOMER_COLUMN_NAME + " TEXT NOT NULL, " +
                CUSTOMER_COLUMN_MENU + " TEXT NOT NULL, " +
                CUSTOMER_COLUMN_LAT + " TEXT NOT NULL," +
                CUSTOMER_COLUMN_LONG + " TEXT NOT NULL" + ")";
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<HashMap<String, String>> getAllData() {
        ArrayList<HashMap<String, String>> data;
        data = new ArrayList<HashMap<String, String>>();
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);

        while (cursor.moveToNext()) {
            HashMap<String, String> items = new HashMap<String, String>();

            int itemId = cursor.getInt(cursor.getColumnIndexOrThrow(CUSTOMER_COLUMN_ID));
            String itemName = cursor.getString(cursor.getColumnIndexOrThrow(CUSTOMER_COLUMN_NAME));
            String itemMenu = cursor.getString(cursor.getColumnIndexOrThrow(CUSTOMER_COLUMN_MENU));
            String itemLat = cursor.getString(cursor.getColumnIndexOrThrow(CUSTOMER_COLUMN_LAT));
            String itemLong = cursor.getString(cursor.getColumnIndexOrThrow(CUSTOMER_COLUMN_LONG));

            items.put(CUSTOMER_COLUMN_ID, Integer.toString(itemId));
            items.put(CUSTOMER_COLUMN_NAME, itemName);
            items.put(CUSTOMER_COLUMN_MENU, itemMenu);
            items.put(CUSTOMER_COLUMN_LAT, itemLat);
            items.put(CUSTOMER_COLUMN_LONG, itemLong);

            data.add(items);

        }

        cursor.close();
        database.close();
        return data;
    }

    public void insert(String name, String menu, String lat, String lng) {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "INSERT INTO " + TABLE_NAME + " (name, menu, lat, lng) " +
                "VALUES ('" + name + "', '" + menu + "', '" + lat + "', '" + lng + "')";
        database.execSQL(query);
        database.close();
    }

//    public void update(int id, String name, String address, float cash) {
//        SQLiteDatabase database = this.getWritableDatabase();
//        String updateQuery = "UPDATE " + TABLE_NAME + " SET "
//                + CUSTOMER_COLUMN_NAME + "='" + name + "', "
//                + CUSTOMER_COLUMN_ADDRESS + "='" + address + "'"
//                + CUSTOMER_COLUMN_CASH + "='" + cash + "', "
//                + " WHERE " + CUSTOMER_COLUMN_ID + "=" + "'" + id + "'";
//        database.execSQL(updateQuery);
//        database.close();
//    }
//
//    public void delete(int id) {
//        SQLiteDatabase database = this.getWritableDatabase();
//        String updateQuery = "DELETE FROM " + TABLE_NAME + " WHERE " + CUSTOMER_COLUMN_ID + "=" + "'" + id + "'";
//        database.execSQL(updateQuery);
//        database.close();
//    }

}
