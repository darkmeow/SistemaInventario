package com.example.horth_000.invsys.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.horth_000.invsys.DbHelper;

/**
 * Created by meow on 11-11-14.
 */
public class CategoriaController {

    private static final String TABLE_NAME = "CATEGORIA";
    public static final String ID_CATEGORIA = "id_categoria";
    public static final String NOMBRE_CATEGORIA = "nombre_categoria";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + ID_CATEGORIA + " text not null, "
            + NOMBRE_CATEGORIA + " text not null);";

    private DbHelper helper;
    private SQLiteDatabase db;

    public CategoriaController(Context context) {
        helper = new DbHelper(context);
        db =  helper.getWritableDatabase();

    }
    private ContentValues gContentValues(String id_categoria, String nombre_categoria){
        ContentValues values = new ContentValues();
        values.put(ID_CATEGORIA, id_categoria);
        values.put(NOMBRE_CATEGORIA, nombre_categoria);

        return values;
    }


    public void insertar(String id_categoria, String nombre_categoria)

    {///revisar esto
        db.insert(TABLE_NAME, ID_CATEGORIA, gContentValues( id_categoria, nombre_categoria));
    }
    ///revisar esto
    public void delete(String nombre_categoria){
        db.delete(TABLE_NAME, NOMBRE_CATEGORIA+ "=?", new String[]{nombre_categoria});
    }
    ///revisar esto
    public void updateUser(String id_categoria, String nombre_categoria){
        db.update(TABLE_NAME, gContentValues( id_categoria, nombre_categoria), NOMBRE_CATEGORIA+ "=?", new String[]{nombre_categoria} );
    }
}