package com.example.horth_000.invsys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.horth_000.invsys.controller.CategoriaController;
import com.example.horth_000.invsys.controller.UsuarioController;
import com.example.horth_000.invsys.model.Usuario;

import org.json.JSONObject;

/**
 * Created by meow on 11-11-14.
 */
public class Login extends Activity {
    private TextView lblGotoRegister;
    private Button btnLogin;
    private EditText inputEmail;
    private EditText inputPassword;
    private TextView loginErrorMsg;
    private UsuarioController userCtl;
    private CategoriaController userCat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        inputEmail = (EditText) findViewById(R.id.txtUsern);
        inputPassword = (EditText) findViewById(R.id.txtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        loginErrorMsg = (TextView) findViewById(R.id.login_error);

        userCtl = new UsuarioController(this);
        userCtl.insertar("Administrador","FULLACCESS", "admin","admin", 0); //agrega admin
        userCat = new CategoriaController(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                Usuario usuario = userCtl.checkLogin(email, password);
                String admin = "admin";
                String pssw = "admin";
                if(usuario != null) {
                    if((usuario.getPassword().equals(admin)) && (usuario.getPassword().equals(pssw))){
                        Intent intent = new Intent(Login.this, AdminPanel.class);
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(Login.this, WelcomeActivity.class);
                        intent.putExtra("Nombre", usuario.getName() + " " + usuario.getSurname());
                        startActivity(intent);
                    }
                } else {
                    Log.d("LOGIN", "Error: usuario invalido");
                }
            }
        });

        lblGotoRegister = (TextView) findViewById(R.id.link_to_register);
        lblGotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Intent itemintent = new Intent(Login.this, Registrar.class);
                Login.this.startActivity(itemintent);}
        });
    }


}
