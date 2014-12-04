package com.example.horth_000.invsys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.horth_000.invsys.controller.ProductoController;

/**
 * Created by horth_000 on 30-11-2014.
 */
public class AddProd extends Activity {
    private ProductoController manager;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addprod);
        manager = new ProductoController(this);
    }

     public void addProd(View v){
         EditText producto = (EditText) findViewById(R.id.edtxtProd);
         EditText distribuidor = (EditText) findViewById(R.id.edtxtDist);
         EditText stock = (EditText) findViewById(R.id.edtxtStock);
         EditText categoria = (EditText) findViewById(R.id.edtxtCategoria);
         EditText fecha_de_ingreso = (EditText) findViewById(R.id.edtxtDate);
         EditText descripcion = (EditText) findViewById(R.id.edtxtDescrip);
         EditText imagen = (EditText) findViewById(R.id.edtxtImagen);

         //manager.insertar(producto.getText().toString(), fecha_de_ingreso.getText().toString(),stock.getText().toString(),categoria.getText().toString(), distribuidor.getText().toString(),descripcion.getText().toString(), imagen.getText().toString());
         startActivity(new Intent(AddProd.this, AdminPanel.class));

    }


}
