package com.canteko.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ComunicatedFragmentsActivity extends AppCompatActivity implements OnControlesFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicated_fragments);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_communicated, new ControlesFragment())
                .commit();
    }

    @Override
    public void botonColorClicked(String color) {
        Toast.makeText(this, "Color recibido: " + color, Toast.LENGTH_LONG).show();
    }

    @Override
    public void botonTextoClicked(String listener) {
        Toast.makeText(this, "Texto recibido: " + listener, Toast.LENGTH_LONG).show();
    }
}