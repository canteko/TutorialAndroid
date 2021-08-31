package com.canteko.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {

    private ListView lista;
    private List<Averia> averias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        lista = findViewById(R.id.listViewAverias);

        averias.add(new Averia("asdasd", "asdasdas", "https://static1.elcorreo.com/www/multimedia/202101/11/media/cortadas/apple-car-icar-kcWG-U130183090282s2E-624x385@El%20Correo.jpg", 0));
        averias.add(new Averia("a432sd", "asdasdas", "https://static1.elcorreo.com/www/multimedia/202101/11/media/cortadas/apple-car-icar-kcWG-U130183090282s2E-624x385@El%20Correo.jpg", 3));
        averias.add(new Averia("as4535d", "asdasdas", "https://static1.elcorreo.com/www/multimedia/202101/11/media/cortadas/apple-car-icar-kcWG-U130183090282s2E-624x385@El%20Correo.jpg", 5));
        averias.add(new Averia("as345d", "asdasdas", "", 2));
        averias.add(new Averia("as123sd", "asdasdas", "", 0));
        averias.add(new Averia("a65sd", "asdasdas", "https://static1.elcorreo.com/www/multimedia/202101/11/media/cortadas/apple-car-icar-kcWG-U130183090282s2E-624x385@El%20Correo.jpg", 3));
        averias.add(new Averia("345d", "asdasdas", "https://static1.elcorreo.com/www/multimedia/202101/11/media/cortadas/apple-car-icar-kcWG-U130183090282s2E-624x385@El%20Correo.jpg", 1));

        MiAdaptadorAverias adaptadorAverias = new MiAdaptadorAverias(
                this,
                R.layout.averia_item,
                averias
        );

        lista.setAdapter(adaptadorAverias);
    }
}