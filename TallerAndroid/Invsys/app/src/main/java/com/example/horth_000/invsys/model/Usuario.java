package com.example.horth_000.invsys.model


import android.app.Activity;

/**
 * Created by meow on 11-11-14.
 */
public class Usuario {

        private String Name = "";
        private String Email = "";
        private String UID = "";

        private static String KEY_SUCCESS = "success";
        private static String KEY_UID = "uid";
        private static String KEY_NAME = "name";
        private static String KEY_EMAIL = "email";
        private static String KEY_CREATED_AT = "created_at";
        private static String KEY_USER = "user";

        private static String login_tag = "login";
        private static String register_tag = "register";

        private Activity activity;


        public void login(Activity activity, String email, String password){
           //conectarse a la base de datos

        }



        public void logout(Activity activity){
            DBLogin dblogin = new DBLogin(activity);
            dblogin.resetTables();
            dblogin.close();
        }


        public boolean isUserLoggedIn(Activity activity){
            DBLogin db = new DBLogin(activity);
            int count = db.getRowCount();
            db.close();
            if(count > 0){
                // user logged in
                return true;
            }
            return false;
        }

        public void readUser(Activity activity){
            DBLogin dblogin = new DBLogin(activity);
            Cursor cursor = dblogin.getCursorUsuario();
            if(cursor.moveToNext()){
                this.setName(cursor.getString(0));
                this.setEmail(cursor.getString(1));
                this.setUID(cursor.getString(2));
            }
            cursor.close();
            dblogin.close();

        }

        public interface OnRegisterUsuario{
            void onRegisterFinish(JSONObject json, String msg);
            void onRegisterException(Exception e, String msg);
            void onRegisterFail(String msg);
        }
        private OnRegisterUsuario ListenerRegisterUsuario;
        public void setOnRegisterUsuario(OnRegisterUsuario l){ListenerRegisterUsuario = l;}

        public interface OnLoginUsuario{
            void onLoginCorrect(JSONObject json, String msg);
            void onLoginWrong(String msg);
        }
        private OnLoginUsuario ListenerLoginUsuario;
        public void setOnLoginUsuario(OnLoginUsuario l){ListenerLoginUsuario = l;}

        public String getName() {return Name;}
        public void setName(String name) {Name = name;}
        public String getEmail() {return Email;}
        public void setEmail(String email) {Email = email;}
        public String getUID() {return UID;}
        public void setUID(String uID) {UID = uID;}

    }
