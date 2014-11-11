package com.example.horth_000.invsys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = (EditText) findViewById(R.id.txtUsern);
        inputPassword = (EditText) findViewById(R.id.txtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        loginErrorMsg = (TextView) findViewById(R.id.login_error);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                Usuario usuario = new Usuario();

                usuario.setOnLoginUsuario(new OnLoginUsuario() {
                    @Override
                    public void onLoginWrong(String msg) {loginErrorMsg.setText(msg);}
                    @Override
                    public void onLoginCorrect(JSONObject json, String msg) {
                        loginErrorMsg.setText("");
                        Intent itemintent = new Intent(Login.this, ActivityPrincipal.class);
                        Login.this.startActivity(itemintent);
                    }
                });
                usuario.login(Login.this, email, password);
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
