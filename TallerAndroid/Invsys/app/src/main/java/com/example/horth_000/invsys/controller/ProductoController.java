package com.example.horth_000.invsys.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.horth_000.invsys.DbHelper;

/**
 * Created by meow on 11-11-14.
 */
public class ProductoController {

    public static final String TABLE_NAME = "PRODUCTO";
    public static final String ID_PRODUCTO = "id_producto";
    public static final String NOMBRE_PRODUCTO = "nombre_producto";
    public static final String FECHA_INGRESO = "fecha_ingreso";
    public static final String STOCK = "stock";
    public static final String NOMBRE_CATEGORIA = "nombre_categoria";
    public static final String NOMBRE_DISTRIBUIDOR = "nombre_distribuidor";
    public static final String DESCRIPCION = "descripcion";
    public static final String IMAGEN = "imagen";


    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + ID_PRODUCTO + " integer primary key, "
            + NOMBRE_PRODUCTO + " text not null, "
            + FECHA_INGRESO + " integer not null,"
            + STOCK + " integer not null,"
            + NOMBRE_CATEGORIA + " text not null,"
            + NOMBRE_DISTRIBUIDOR + " text not null,"
            + DESCRIPCION + "text not null,"
            + IMAGEN + " text not null );";

    private DbHelper helper;
    private SQLiteDatabase db;

    public ProductoController(Context context) {
        helper = new DbHelper(context);
        db =  helper.getWritableDatabase();

    }
    private ContentValues gContentValues(String id_producto, String nombre_producto,
                                         String fecha_ingreso, String stock,
                                         String nombre_categoria, String nombre_distribuidor,
                                         String descripcion, String imagen){
        ContentValues values = new ContentValues();
        values.put(ID_PRODUCTO, id_producto);
        values.put(NOMBRE_PRODUCTO, nombre_producto );
        values.put(FECHA_INGRESO, fecha_ingreso);
        values.put(STOCK, stock);
        values.put(NOMBRE_CATEGORIA, nombre_categoria);
        values.put(NOMBRE_DISTRIBUIDOR, nombre_distribuidor);
        values.put(DESCRIPCION, descripcion);
        values.put(IMAGEN, imagen);
        return values;
    }
    public void insertar(String id_producto, String nombre_producto,
                         String fecha_ingreso, String stock,
                         String nombre_categoria, String nombre_distribuidor,
                         String descripcion, String imagen)

    {///revisar esto
        db.insert(TABLE_NAME, ID_PRODUCTO, gContentValues( id_producto,  nombre_producto,
                                                            fecha_ingreso, stock,
                                                            nombre_categoria, nombre_distribuidor,
                                                            descripcion, imagen));
    }
    ///revisar esto
    public void delete(String nombre_producto){
        db.delete(TABLE_NAME, NOMBRE_PRODUCTO+ "=?", new String[]{nombre_producto});
    }
    ///revisar esto
    public void updateUser(String id_producto, String nombre_producto,
                           String fecha_ingreso, String stock,
                           String nombre_categoria, String nombre_distribuidor,
                           String descripcion, String imagen){
        db.update(TABLE_NAME, gContentValues(id_producto,  nombre_producto,
                fecha_ingreso, stock,
                nombre_categoria, nombre_distribuidor,
                descripcion, imagen), NOMBRE_PRODUCTO+ "=?", new String[]{nombre_producto} );
    }
}
