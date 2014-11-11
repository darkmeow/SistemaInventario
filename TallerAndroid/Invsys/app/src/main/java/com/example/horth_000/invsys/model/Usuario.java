package com.example.horth_000.invsys.model;


import android.app.Activity;
import android.database.Cursor;

import org.json.JSONObject;

/**
 * Created by meow on 11-11-14.
 */
public class Usuario {

    private String Name = "";
    private String Surname = "";
    private String ID = "";
    private String Username = "";
    private String Password = "";


    private static String KEY_SUCCESS = "success";
    private static String KEY_UID = "uid";
    private static String KEY_NAME = "name";
    private static String KEY_EMAIL = "email";
    private static String KEY_CREATED_AT = "created_at";
    private static String KEY_USER = "user";

    private static String login_tag = "login";
    private static String register_tag = "register";

    private Activity activity;

    public String getName() {return Name;}
    public void setName(String name) {Name = name;}
    public String getUID() {return ID;}
    public void setUID(String uID) {ID = uID;}

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
