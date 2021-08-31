package com.canteko.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SimpleListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;
    private List<String> talleres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        lista = findViewById(R.id.listViewTalleres);
        talleres = new ArrayList<>();
        talleres.add("asdasdas");
        talleres.add("adfgdg");
        talleres.add("dfgdfgdsdas");
        talleres.add("awerwsdas");
        talleres.add("afhdfgdgdas");
        talleres.add("adfgs");
        talleres.add("111111");
        talleres.add("dfgdfgdsdas");
        talleres.add("awerwsdas");
        talleres.add("afhdfgdgdas");
        talleres.add("adfgs");
        talleres.add("111111");
        talleres.add("dfgdfgdsdas");
        talleres.add("awerwsdas");
        talleres.add("afhdfgdgdas");
        talleres.add("adfgs");
        talleres.add("111111");
        talleres.add("dfgdfgdsdas");
        talleres.add("awerwsdas");
        talleres.add("afhdfgdgdas");
        talleres.add("adfgs");
        talleres.add("111111");

        ArrayAdapter<String> adaptadorTalleres = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                talleres
        );

        lista.setAdapter(adaptadorTalleres);

        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Has pulsado en: " + talleres.get(position), Toast.LENGTH_LONG).show();

        view.animate().rotationX(180).rotationY(360).setDuration(1000).start();
    }
}