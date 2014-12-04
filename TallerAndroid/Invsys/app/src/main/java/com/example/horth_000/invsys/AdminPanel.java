package com.example.horth_000.invsys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by horth_000 on 29-11-2014.
 */
public class AdminPanel extends Activity {

    private Button btnAddProd;
    private Button btnCategorias;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpanel);
        btnAddProd = (Button) findViewById(R.id.btnAddProd);
        btnCategorias = (Button) findViewById(R.id.btnCategorias);
        btnAddProd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(AdminPanel.this, AddProd.class);
                startActivity(intent);
            }
        });
        btnCategorias.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(AdminPanel.this, Categorias.class);
                startActivity(intent);

            }
        });
    }
}