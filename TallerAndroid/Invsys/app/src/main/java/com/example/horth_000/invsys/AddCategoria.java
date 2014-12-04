package com.example.horth_000.invsys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.horth_000.invsys.controller.CategoriaController;
import com.example.horth_000.invsys.model.Categoria;

/**
 * Created by meow on 03-12-14.
 */
public class AddCategoria extends Activity {
    private CategoriaController manager;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcategoria);
        manager = new CategoriaController(this);
    }

    public void addCategoria(View v){
        EditText nombre_categoria = (EditText) findViewById(R.id.edtxtCategoria);

         manager.insertar(nombre_categoria.getText().toString());

        startActivity(new Intent(AddCategoria.this, Categorias.class));

    }


}
