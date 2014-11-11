package com.example.horth_000.invsys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by roberto on 11/11/14.
 */
public class WelcomeActivity extends Activity {

    private TextView welcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);

        String nombre = getIntent().getExtras().getString("Nombre");
        welcomeTextView.setText("Bienvenido "+nombre+"!");
    }
}
