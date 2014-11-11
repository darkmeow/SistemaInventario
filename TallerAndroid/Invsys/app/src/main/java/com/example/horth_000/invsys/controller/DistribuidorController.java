package com.example.horth_000.invsys.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.horth_000.invsys.DbHelper;

/**
 * Created by meow on 11-11-14.
 */
public class DistribuidorController {

    private static final String TABLE_NAME = "DISTRIBUIDOR";
    public static final String ID_DISTRIBUIDOR = "id_distribuidor";
    public static final String NOMBRE_DISTRIBUIDOR = "nombre_distribuidor";
    public static final String CORREO_DISTRIBUIDOR = "correo_distribuidor";
    public static final String TELEFONO_DISTRIBUIDOR = "telefono_distribuidor";
    public static final String DIRECCION_DISTRIBUIDOR = "direccion_distribuidor";


    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + ID_DISTRIBUIDOR + " integer primary key, "
            + NOMBRE_DISTRIBUIDOR + " text not null, "
            + CORREO_DISTRIBUIDOR + " text not null,"
            + TELEFONO_DISTRIBUIDOR + " integer not null,"
            + DIRECCION_DISTRIBUIDOR + " text not null,"
            +"FOREIGN KEY ("+NOMBRE_DISTRIBUIDOR+") REFERENCES "+ProductoController.TABLE_NAME+" ("+NOMBRE_DISTRIBUIDOR+"));";


    private DbHelper helper;
    private SQLiteDatabase db;

    public DistribuidorController(Context context) {
        helper = new DbHelper(context);
        db =  helper.getWritableDatabase();

    }
    private ContentValues gContentValues(String id_distribuidor, String nombre_distribuidor,
                                         String correo_distribuidor, String telefono_distribuidor,
                                         String direccion_distribuidor){
        ContentValues values = new ContentValues();
        values.put(ID_DISTRIBUIDOR, id_distribuidor);
        values.put(NOMBRE_DISTRIBUIDOR, nombre_distribuidor);
        values.put(CORREO_DISTRIBUIDOR, correo_distribuidor);
        values.put(TELEFONO_DISTRIBUIDOR, telefono_distribuidor);
        values.put(DIRECCION_DISTRIBUIDOR, direccion_distribuidor);

        return values;
    }

    //REVISAR
    public void insertar(String id_distribuidor, String nombre_distribuidor,
                         String correo_distribuidor, String telefono_distribuidor,
                         String direccion_distribuidor){



        db.insert(TABLE_NAME, ID_DISTRIBUIDOR, gContentValues( id_distribuidor,  nombre_distribuidor,
                 correo_distribuidor,  telefono_distribuidor,
                 direccion_distribuidor));
    }
    //REVISAR
    public void delete(String nombre_distribuidor){
        db.delete(TABLE_NAME, NOMBRE_DISTRIBUIDOR+ "=?", new String[]{nombre_distribuidor});
    }
    //REVISAR
    public void updateUser(String id_distribuidor, String nombre_distribuidor,
                           String correo_distribuidor, String telefono_distribuidor,
                           String direccion_distribuidor){
        db.update(TABLE_NAME, gContentValues(id_distribuidor,  nombre_distribuidor,
                correo_distribuidor,  telefono_distribuidor,
                direccion_distribuidor), NOMBRE_DISTRIBUIDOR+ "=?", new String[]{nombre_distribuidor} );
    }






}
