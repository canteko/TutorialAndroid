package com.canteko.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int i;
    private String metodo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        metodo = "onCreate";
        Log.d(":::TAG_cicloVida", "Ciclovida: " + metodo);
        i = 0;
    }

    @Override
    protected void onStart() {
        super.onStart();
        metodo = "onStart";
        Log.d(":::TAG_cicloVida", "Ciclovida: " + metodo);
        i++;
    }

    @Override
    protected void onResume() {
        super.onResume();
        metodo = "onResume";
        Log.d(":::TAG_cicloVida", "Ciclovida: " + metodo);
        i++;
    }

    @Override
    protected void onPause() {
        super.onPause();
        metodo = "onPause";
        Log.d(":::TAG_cicloVida", "Ciclovida: " + metodo);
        i++;
    }

    @Override
    protected void onStop() {
        super.onStop();
        metodo = "onStop";
        Log.d(":::TAG_cicloVida", "Ciclovida: " + metodo);
        i--;
    }

    public void initSecActivity(View view) {
//        Toast.makeText(this, "Esto es un toast con listener", Toast.LENGTH_LONG).show();
        // Escribiremos el código necesario para iniciar
        // el activity secundario (Intent Explícito)

        Intent intentSecundario = new Intent(this, SecundarioActivity.class);
        intentSecundario.putExtra("numero", 5);
        intentSecundario.putExtra("nombre", "Miguel");
        startActivity(intentSecundario);
    }
}