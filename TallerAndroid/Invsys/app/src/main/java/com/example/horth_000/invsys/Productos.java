package com.example.horth_000.invsys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by meow on 03-12-14.
 */
public class Productos extends Activity {
        private Button btnAddProd;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_productos);


            btnAddProd = (Button) findViewById(R.id.btnAddCategorias);

            btnAddProd.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(Productos.this, AddProd.class);
                    startActivity(intent);

                }
            });
        }
}

