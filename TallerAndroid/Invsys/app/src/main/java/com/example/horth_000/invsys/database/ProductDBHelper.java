package com.example.horth_000.invsys.database;

import android.content.Context;
import android.database.Cursor;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class ProductDBHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "products.db";
    private static final int DATABASE_VERSION = 1;

    public ProductDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


}