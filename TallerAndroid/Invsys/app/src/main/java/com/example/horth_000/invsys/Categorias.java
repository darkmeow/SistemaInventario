package com.example.horth_000.invsys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import com.example.horth_000.invsys.model.Producto;

/**
 * Created by horth_000 on 30-11-2014.
 */
public class Categorias extends Activity {
    private Button btnAddCategorias;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);


        btnAddCategorias = (Button) findViewById(R.id.btnAddCategorias);

        btnAddCategorias.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Categorias.this, AddCategoria.class);
                startActivity(intent);

            }
        });
    }
}
