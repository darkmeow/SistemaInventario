package com.example.horth_000.invsys;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

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
        /*
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
        */
    }

    public void mostrarProductos(View view) {
        Intent intent = new Intent(AdminPanel.this, Productos.class);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id) {
            case R.id.action_search:
                return true;
            case R.id.action_barcode:
                IntentIntegrator intentIntegrator = new IntentIntegrator(this); // where this is activity
                intentIntegrator.initiateScan(IntentIntegrator.ALL_CODE_TYPES); // or QR_CODE_TYPES if you need to scan QR
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu( menu );
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_login, menu);

        MenuItem searchMenuItem = menu.findItem( R.id.action_search ); // get my MenuItem with placeholder submenu
        searchMenuItem.expandActionView(); // Expand the search menu item in order to show by default the query

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));


        return true;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            // handle scan result
            Intent searchIntent = new Intent(Intent.ACTION_SEARCH);
            searchIntent.putExtra(SearchManager.QUERY, scanResult.getContents()); // query contains search string
            searchIntent.setComponent(new ComponentName("com.example.horth_000.invsys","com.example.horth_000.invsys.Productos"));

            startActivity(searchIntent);
        }
    }
}