package com.dani.lakeviewcoffee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Nama Tebel
    public static final String TABLE_NAME = "tbl_transaction";

    // Nama kolom dalam tabel
    public static final String _ID = "_id";
    public static final String NOMEJA = "nomeja";
    public static final String CAPPUCCINO = "cappuccino";
    public static final String ESPRESSO = "espresso";
    public static final String MACCHIATO = "macchiato";
    public static final String MOCHA = "mocha";
    public static final String RISTRETTO = "ristretto";
    public static final String CAFE_LATTE = "cafe_latte";
    public static final String AMERICANO = "americano";
    public static final String MOCHA_LATE = "mocha_late";
    public static final String AFFOGATO_LATE = "affogato_late";
    public static final String TOTAL = "total";
    public static final String TANGGAL = "tanggal";
    public static final String JAM = "jam";

    // Nama Database
    static final String DB_NAME = "DANI.DB";

    // Versi Database
    static final int DB_VERSION = 1;

    // Membuat query tabel
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOMEJA + " TEXT NOT NULL, " + CAPPUCCINO + " TEXT, " + ESPRESSO + " TEXT, " + MACCHIATO + " TEXT, " + MOCHA + " TEXT, " + RISTRETTO + " TEXT, " + CAFE_LATTE + " TEXT, " + AMERICANO + " TEXT, " + MOCHA_LATE + " TEXT, " + AFFOGATO_LATE + " TEXT, " + TOTAL + " TEXT, " + TANGGAL + " TEXT, " + JAM + " TEXT);";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
