package com.example.horth_000.invsys.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.horth_000.invsys.database.DbHelper;

/**
 * Created by meow on 11-11-14.
 */
public class CategoriaController {

    private static final String TABLE_NAME = "categoria";
    public static final String ID_CATEGORIA = "id_categoria";
    public static final String NOMBRE_CATEGORIA = "nombre_categoria";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + ID_CATEGORIA + " integer primary key autoincrement, "
            + NOMBRE_CATEGORIA + " text not null);";

    private DbHelper helper;
    private SQLiteDatabase db;

    public CategoriaController(Context context) {
        helper = new DbHelper(context);
        db =  helper.getWritableDatabase();

    }

    private ContentValues gContentValues(String nombre_categoria){
        ContentValues values = new ContentValues();
        values.put(NOMBRE_CATEGORIA, nombre_categoria);

        return values;
    }


    public void insertar(String nombre_categoria){//inserta categoria

        String[] columns = new String[]{NOMBRE_CATEGORIA};
        String[] args = new String[] {nombre_categoria};
        Cursor results = db.query(TABLE_NAME, columns, NOMBRE_CATEGORIA + "=?", args, null, null, null, null);

        if(results.getCount() < 1)
            db.insert(TABLE_NAME, NOMBRE_CATEGORIA, gContentValues(nombre_categoria));

    }

    public void updateUser(String nombre_categoria){ //editar valores de categoria
        db.update(TABLE_NAME, gContentValues(nombre_categoria), NOMBRE_CATEGORIA+ "=?", new String[]{nombre_categoria} );
    }
}