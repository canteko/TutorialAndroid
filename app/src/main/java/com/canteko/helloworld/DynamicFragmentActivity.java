package com.canteko.helloworld;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;


public class DynamicFragmentActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dynamic_fragment);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener((view) -> {
            // Modificamos el fragmento que sale en la pantalla
            // dentro del frameLayout
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, (first ? new PrimerFragment() : new SegundoFragment()))
                    .commit();
            first = !first;
        });
    }
}