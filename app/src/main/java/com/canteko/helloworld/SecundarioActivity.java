package com.canteko.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Toast;

public class SecundarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundario);

        Bundle extras = getIntent().getExtras();

        int n = extras.getInt("numero");
        String s = extras.getString("nombre");

        Toast.makeText(this, "Nombre: " + s + ", numero: " + n, Toast.LENGTH_SHORT).show();
    }

    public void createAlarm(View view) {
        // Intent implícito, no tiene por qué realizarsedentro de la aplicación
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, 11);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 30);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Mensaje de prueba");

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No ha sido posible crear una alarma", Toast.LENGTH_LONG).show();
        }
    }

    public void createCall(View view) {
        // Intent implicito para lanzar a la app de llamadas
        Uri number = Uri.parse("tel:+34677300665");
        Intent intent = new Intent(Intent.ACTION_DIAL, number);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No ha sido posible abrir la aplicación de llamada", Toast.LENGTH_LONG).show();
        }
    }

    public void goToLinearLayout(View view) {
        Intent linearLayoutIntent = new Intent(this, LinearLayoutActivity.class);
        startActivity(linearLayoutIntent);
    }

    public void goToRelativeLayout(View view) {
        Intent RelativeLayoutIntent = new Intent(this, RelativeLayoutActivity.class);
        startActivity(RelativeLayoutIntent);
    }
}