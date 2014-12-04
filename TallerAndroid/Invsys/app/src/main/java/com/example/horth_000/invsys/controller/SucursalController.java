package com.example.horth_000.invsys.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.horth_000.invsys.database.DbHelper;

/**
 * Created by meow on 11-11-14.
 */
public class SucursalController {

    public static final String TABLE_NAME = "SUCURSAL";
    public static final String ID_SUCURSAL = "id_sucursal";
    public static final String NOMBRE_SUCURSAL = "nombre_sucursal";
    public static final String DIRECCION_SUCURSAL = "direccion_sucursal";
    public static final String ADMINISTRADOR_SUCURSAL = "administrador_sucursal";


    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
        + ID_SUCURSAL + " integer primary key, "
        + NOMBRE_SUCURSAL + " text not null, "
        + DIRECCION_SUCURSAL + " text not null,"
        + ADMINISTRADOR_SUCURSAL + " text not null );";

private DbHelper helper;
private SQLiteDatabase db;

    public SucursalController(Context context) {
        helper = new DbHelper(context);
        db =  helper.getWritableDatabase();

    }
    private ContentValues gContentValues(String id_sucursal, String nombre_sucursal,
                                         String direccion_sucursal, String administrador_sucursal){
        ContentValues values = new ContentValues();
        values.put(ID_SUCURSAL, id_sucursal);
        values.put(NOMBRE_SUCURSAL, nombre_sucursal );
        values.put(DIRECCION_SUCURSAL, direccion_sucursal);
        values.put(ADMINISTRADOR_SUCURSAL,administrador_sucursal);

        return values;
    }
    public void insertar(String id_sucursal, String nombre_sucursal,
                         String direccion_sucursal, String administrador_sucursal)

    {///revisar esto
        db.insert(TABLE_NAME,ID_SUCURSAL , gContentValues( id_sucursal,  nombre_sucursal,
                direccion_sucursal,  administrador_sucursal));
    }
    ///revisar esto
    public void delete(String nombre_sucursal){
        db.delete(TABLE_NAME, NOMBRE_SUCURSAL+ "=?", new String[]{nombre_sucursal});
    }
    ///revisar esto
    public void updateUser(String id_sucursal, String nombre_sucursal,
                           String direccion_sucursal, String administrador_sucursal){
        db.update(TABLE_NAME, gContentValues(id_sucursal,  nombre_sucursal,
                direccion_sucursal,  administrador_sucursal), NOMBRE_SUCURSAL+ "=?", new String[]{nombre_sucursal} );
    }
}
