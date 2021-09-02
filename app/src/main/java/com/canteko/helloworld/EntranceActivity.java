package com.canteko.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_HelloWorld);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
    }

    public void goToActivity(View view) {
        try {
            String activityClassName = view.getTag().toString();
            Class c = Class.forName(activityClassName);
            Intent intent = new Intent(this, c);
            startActivity(intent);
        } catch(Exception e) {
            Toast.makeText(this, "Activity no encontrado", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }
}