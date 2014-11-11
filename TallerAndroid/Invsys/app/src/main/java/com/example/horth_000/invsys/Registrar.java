package com.example.horth_000.invsys;

import android.app.Activity;
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void registrar(View v){
        EditText name = (EditText) findViewById(R.id.txtname);
        EditText surname = (EditText) findViewById(R.id.txtsurname);
        EditText username = (EditText) findViewById(R.id.txtusername);
        EditText pass = (EditText) findViewById(R.id.txtpass);
        manager.insertar(name.getText().toString(), surname.getText().toString(),username.getText().toString(),pass.getText().toString());
    }
}
