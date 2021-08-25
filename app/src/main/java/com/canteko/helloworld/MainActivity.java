package com.canteko.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

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

    public void tipoAveriaClicked(View view) {
        CheckBox checkbox = (CheckBox) view;
        boolean checked = checkbox.isChecked();
        String tipo = "";

        // Sobre que checkbox se ha hecho click
        switch(checkbox.getId()) {
            case R.id.checkBoxChapa:
                tipo = "Chapa";
                break;
            case R.id.checkBoxCristal:
                tipo = "Cristal";
                break;
            case R.id.checkBoxMecanico:
                tipo = "Mecanico";
                break;
        }

        Toast.makeText(this, "Checkbox " + tipo + ": " + checked, Toast.LENGTH_LONG).show();
    }

    public void onRadioButtonClicked(View view) {
        RadioButton checkbox = (RadioButton) view;
        boolean checked = checkbox.isChecked();
        String tipo = "";

        // Sobre que checkbox se ha hecho click
        switch(checkbox.getId()) {
            case R.id.radio_ninjas:
                tipo = "ninjas";
                break;
            case R.id.radio_pirates:
                tipo = "pirates";
                break;
        }

        Toast.makeText(this, "Radio " + tipo + ": " + checked, Toast.LENGTH_LONG).show();
    }

    public void getTipoAveria(View view) {
        RadioGroup radiogroup = findViewById(R.id.radioGroup);
        String tipo = "";
        switch(radiogroup.getCheckedRadioButtonId()) {
            case R.id.radio_ninjas:
                tipo = "ninjas";
                break;
            case R.id.radio_pirates:
                tipo = "pirates";
                break;
        }

        Toast.makeText(this, "Radio " + tipo, Toast.LENGTH_LONG).show();
    }

    public void toggleButtonAction(View view) {
        ToggleButton toggleButton = (ToggleButton) view;
        String tipo = (toggleButton.isChecked() ? "SI" : "NO");
        Toast.makeText(this, "Toggle " + tipo + ", " + toggleButton.getText(), Toast.LENGTH_LONG).show();
    }
}