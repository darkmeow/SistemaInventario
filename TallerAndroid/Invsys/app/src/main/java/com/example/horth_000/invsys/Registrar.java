package com.example.horth_000.invsys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.horth_000.invsys.controller.UsuarioController;


public class Registrar extends Activity {
    private UsuarioController manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

     manager = new UsuarioController(this);

    }

    public void registrar(View v){
        EditText name = (EditText) findViewById(R.id.txtname);
        EditText surname = (EditText) findViewById(R.id.txtsurname);
        EditText username = (EditText) findViewById(R.id.txtusername);
        EditText pass = (EditText) findViewById(R.id.txtpass);
        manager.insertar(name.getText().toString(), surname.getText().toString(),username.getText().toString(),pass.getText().toString(),0);
        startActivity(new Intent(Registrar.this, Login.class));

    }
}
