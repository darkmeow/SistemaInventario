package com.example.horth_000.invsys.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.horth_000.invsys.database.DbHelper;
import com.example.horth_000.invsys.database.ProductDBHelper;

/**
 * Created by meow on 11-11-14.
 */
public class ProductoController {

    public static final String TABLE_NAME = "products";
    public static final String ID_PRODUCTO = "_id";
    public static final String SKU = "sku";
    public static final String NOMBRE_PRODUCTO = "name";
    public static final String LABORATORIO = "laboratory";
    public static final String NOMBRE_CORTO = "short_name";
    public static final String PRESCRIPCION = "prescription";
    public static final String EFECTO_TERAPEUTICO = "therapeutic_effect";
    public static final String CONCENTRACION = "concentration";
    public static final String CONCENTRACION_UNIDAD = "concentration_unit";
    public static final String FORMA_FARMACEUTICA = "pharmaceutical_form";
    public static final String CANTIDAD = "quantity";
    public static final String CANTIDAD_UNIDAD = "quantity_unit";
    public static final String OTRO = "other";
    public static final String PRECIO_BAJO = "lowest_price";
    public static final String PRECIO_ALTO = "highest_price";
    public static final String PRINCIPIO_ACTIVO_1 = "ap1";
    public static final String PRINCIPIO_ACTIVO_2 = "ap2";
    public static final String PRINCIPIO_ACTIVO_3 = "ap3";
    public static final String[] columns = new String[] {ID_PRODUCTO, SKU, NOMBRE_PRODUCTO, LABORATORIO, NOMBRE_CORTO, PRESCRIPCION,
            EFECTO_TERAPEUTICO, CONCENTRACION, CONCENTRACION_UNIDAD, FORMA_FARMACEUTICA, CANTIDAD, CANTIDAD_UNIDAD,
            OTRO, PRECIO_BAJO, PRECIO_ALTO, PRINCIPIO_ACTIVO_1, PRINCIPIO_ACTIVO_2, PRINCIPIO_ACTIVO_3};


    private ProductDBHelper helper;
    private SQLiteDatabase db;

    public ProductoController(Context context) {
        helper = new ProductDBHelper(context);
        db =  helper.getWritableDatabase();
    }

    public Cursor buscar(String query) {
        Cursor results = db.query(TABLE_NAME, columns, query, null, null, null, null, null);

        return results;
    }
    public Cursor todos() {
        Cursor results = db.query(TABLE_NAME, columns, null, null, null, null, null);

        if (results != null) {
            results.moveToFirst();
        }

        return results;
    }

    public ProductDBHelper getHelper() {
        return helper;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
