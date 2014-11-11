package com.example.horth_000.invsys.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.horth_000.invsys.DbHelper;

import java.security.PublicKey;

/**
 * Created by horth_000 on 10-11-2014.
 */
public class UsuarioController {
    public static final String TABLE_NAME = "user";
    public  static final String CN_ID = "id";
    public  static final  String CN_NAME = "name";
    public  static final  String CN_SURNAME = "surname";
    public  static final  String CN_USERNAME = "username";
    public static final String CN_PASS = "password";

    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + CN_ID  + " integer primary key autoincrement,"
            + CN_NAME + " text not null,"
            + CN_SURNAME + " text,"
            + CN_USERNAME + " text not null,"
            + CN_PASS + " text not null);";

    private DbHelper helper;
    private  SQLiteDatabase db;

    public UsuarioController(Context context) {
        helper = new DbHelper(context);
        db =  helper.getWritableDatabase();

    }
    private  ContentValues gContentValues(String name, String surname, String username, String pass){
        ContentValues values = new ContentValues();
        values.put(CN_NAME, name);
        values.put(CN_SURNAME, surname);
        values.put(CN_USERNAME, username);
        values.put(CN_PASS, pass);

        return values;
    }
    public void insertar(String name, String surname, String username, String pass){
        db.insert(TABLE_NAME, CN_SURNAME, gContentValues(name, surname,  username,  pass));
    }

    public void delete(String username){
        db.delete(TABLE_NAME, CN_USERNAME+ "=?", new String[]{username});
    }
    public void updateUser(String name, String surname, String username, String pass){
        db.update(TABLE_NAME, gContentValues(name, surname, username,  pass), CN_USERNAME+ "=?", new String[]{username} );
    }

}
