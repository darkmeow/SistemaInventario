package com.example.horth_000.invsys.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.horth_000.invsys.database.DbHelper;
import com.example.horth_000.invsys.model.Usuario;

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
    public static final String CN_BOD = "isBodeguero";

    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + CN_ID  + " integer primary key autoincrement,"
            + CN_NAME + " text not null,"
            + CN_SURNAME + " text,"
            + CN_USERNAME + " text not null,"
            + CN_PASS + " text not null,"
            + CN_BOD + " integer);";

    private DbHelper helper;
    private  SQLiteDatabase db;

    public UsuarioController(Context context) {
        helper = new DbHelper(context);
        db =  helper.getWritableDatabase();

    }
    private  ContentValues gContentValues(String name, String surname, String username, String pass, int isBodeguero){
        ContentValues values = new ContentValues();
        values.put(CN_NAME, name);
        values.put(CN_SURNAME, surname);
        values.put(CN_USERNAME, username);
        values.put(CN_PASS, pass);
        values.put(CN_BOD, isBodeguero);

        return values;
    }
    public void insertar(String name, String surname, String username, String pass, int isBodeguero){
        String[] columns = new String[]{CN_USERNAME};
        String[] args = new String[] {username};
        Cursor results = db.query(TABLE_NAME, columns, CN_USERNAME + "=?", args, null, null, null, null);

        if(results.getCount() < 1)
            db.insert(TABLE_NAME, CN_SURNAME, gContentValues(name, surname,  username,  pass, isBodeguero));

    }

    public void delete(String username){
        db.delete(TABLE_NAME, CN_USERNAME+ "=?", new String[]{username});
    }
    public void updateUser(String name, String surname, String username, String pass, int isBodeguero){
        db.update(TABLE_NAME, gContentValues(name, surname, username,  pass, isBodeguero), CN_USERNAME+ "=?", new String[]{username} );
    }

    public Usuario checkLogin(String username, String password) {
        String[] columns = new String[]{CN_ID, CN_NAME, CN_SURNAME, CN_USERNAME, CN_PASS, CN_BOD};
        String[] args = new String[] {username, password};
        Cursor results = db.query(TABLE_NAME, columns, CN_USERNAME + "=? AND " + CN_PASS + "=?", args, null, null, null, null);

        if(results.getCount() < 1)
            return null;

        Usuario user = new Usuario();
        results.moveToFirst();
        user.setName(results.getString(results.getColumnIndex(CN_NAME)));
        user.setUsername(results.getString(results.getColumnIndex(CN_USERNAME)));
        user.setSurname(results.getString(results.getColumnIndex(CN_SURNAME)));
        user.setPassword(results.getString(results.getColumnIndex(CN_PASS)));
        user.setIsBodeguero(results.getInt(results.getColumnIndex(CN_BOD)));
        user.setUID(results.getString(results.getColumnIndex(CN_ID)));

        return user;
    }

}
