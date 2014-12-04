package com.example.horth_000.invsys;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.horth_000.invsys.controller.CategoriaController;
import com.example.horth_000.invsys.controller.UsuarioController;
import com.example.horth_000.invsys.model.Usuario;

/**
 * Created by horth_000 on 10-11-2014.
 */
public class DbHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "invSys.sqlite";
    private static  final int DB_SCHEMA_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null,  DB_SCHEMA_VERSION);
    }

    @Override //crea tablas
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(UsuarioController.CREATE_TABLE);
        db.execSQL(CategoriaController.CREATE_TABLE);
        //otros controladores para crear sus tablas

    }

    @Override //actualizar
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
