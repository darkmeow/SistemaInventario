package com.example.horth_000.invsys;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.horth_000.invsys.controller.ProductoController;

/**
 * Created by meow on 03-12-14.
 */
public class Productos extends Activity {
    private ProductoController prodCtl;
    private SimpleCursorAdapter dataAdapter;
    private ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        prodCtl = new ProductoController(this);
        displayListView();
        handleIntent(getIntent());
    }

    private void displayListView() {

        Cursor cursor = prodCtl.todos();

        // The desired columns to be bound
        String[] columns = new String[] {
                ProductoController.NOMBRE_PRODUCTO
        };

        // the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.productName
        };

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.product_list_item,
                cursor,
                columns,
                to,
                0);

        listView = (ListView) findViewById(R.id.listView2);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // Get the state's capital from this row in the database.

            }
        });


    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        Log.d("PRODUCTOS", "search!");
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
            Cursor cursor = prodCtl.buscar(ProductoController.NOMBRE_PRODUCTO + " LIKE '%"+query+"%' OR "+ProductoController.SKU + " = '"+query+"'");

            String[] columns = new String[] {
                    ProductoController.NOMBRE_PRODUCTO
            };

            // the XML defined views which the data will be bound to
            int[] to = new int[] {
                    R.id.productName
            };

            // create the adapter using the cursor pointing to the desired data
            //as well as the layout information
            dataAdapter = new SimpleCursorAdapter(
                    this, R.layout.product_list_item,
                    cursor,
                    columns,
                    to,
                    0);

            listView.setAdapter(dataAdapter);
        }
    }

    public void agregarProducto(View view) {
        Intent intent = new Intent(Productos.this, AddProd.class);
        startActivity(intent);
    }
}

