package com.dani.lakeviewcoffee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    // Query insert data
    public void insert(String nomeja,String cappuccino, String espresso, String macchiato,  String mocha, String ristretto, String cafe_latte,String americano, String mocha_late, String affogato_late, String total, String tanggal,
                       String jam) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.NOMEJA, nomeja);
        contentValue.put(DatabaseHelper.CAPPUCCINO, cappuccino );
        contentValue.put(DatabaseHelper.ESPRESSO, espresso);
        contentValue.put(DatabaseHelper.MACCHIATO, macchiato);
        contentValue.put(DatabaseHelper.MOCHA, mocha);
        contentValue.put(DatabaseHelper.RISTRETTO, ristretto);
        contentValue.put(DatabaseHelper.CAFE_LATTE, cafe_latte);
        contentValue.put(DatabaseHelper.AMERICANO, americano);
        contentValue.put(DatabaseHelper.MOCHA_LATE, mocha_late);
        contentValue.put(DatabaseHelper.AFFOGATO_LATE, affogato_late);
        contentValue.put(DatabaseHelper.TOTAL, total);
        contentValue.put(DatabaseHelper.TANGGAL, tanggal);
        contentValue.put(DatabaseHelper.JAM, jam);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    // Query ambil/read data
    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.NOMEJA, DatabaseHelper.CAPPUCCINO,
                DatabaseHelper.ESPRESSO, DatabaseHelper.MACCHIATO,DatabaseHelper.MOCHA, DatabaseHelper.RISTRETTO,
                DatabaseHelper.CAFE_LATTE,DatabaseHelper.AMERICANO, DatabaseHelper.MOCHA_LATE, DatabaseHelper.AFFOGATO_LATE,
                DatabaseHelper.TOTAL, DatabaseHelper.TANGGAL, DatabaseHelper.JAM };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    // Query update data
    public int update(long _id, String nomeja, String cappuccino, String espresso, String macchiato,
                      String mocha, String ristretto, String cafe_latte,String americano,
                      String mocha_late, String affogato_late, String total, String tanggal,
                      String jam) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NOMEJA, nomeja);
        contentValues.put(DatabaseHelper.CAPPUCCINO, cappuccino );
        contentValues.put(DatabaseHelper.ESPRESSO, espresso);
        contentValues.put(DatabaseHelper.MACCHIATO, macchiato);
        contentValues.put(DatabaseHelper.MOCHA, mocha);
        contentValues.put(DatabaseHelper.RISTRETTO, ristretto);
        contentValues.put(DatabaseHelper.CAFE_LATTE, cafe_latte);
        contentValues.put(DatabaseHelper.AMERICANO, americano);
        contentValues.put(DatabaseHelper.MOCHA_LATE, mocha_late);
        contentValues.put(DatabaseHelper.AFFOGATO_LATE, affogato_late);
        contentValues.put(DatabaseHelper.TOTAL, total);
        contentValues.put(DatabaseHelper.TANGGAL, tanggal);
        contentValues.put(DatabaseHelper.JAM, jam);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    // Query delete data
    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }
}
