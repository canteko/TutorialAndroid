package com.canteko.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class MiAdaptadorAverias extends ArrayAdapter<Averia> {
    Context ctx;
    int layoutTemplate;
    List<Averia> averiaList;

    public MiAdaptadorAverias(@NonNull Context context, int resource, @NonNull List<Averia> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.averiaList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);

        // Obtenemos la info del objeto de la lista
        Averia elementoActual = averiaList.get(position);

        // Rescatar los elementos de la interfaz
        TextView textViewTitulo = v.findViewById(R.id.textViewAveriaTitulo);
        TextView textViewModelo = v.findViewById(R.id.textViewModeloCocheAveria);
        TextView textViewPresupuestos = v.findViewById(R.id.textViewPresupuestos);
        ImageView imageAveria = v.findViewById(R.id.imageViewPhoto);

        textViewTitulo.setText(elementoActual.getTitulo());
        textViewModelo.setText(elementoActual.getModeloCoche());
        textViewPresupuestos.setText((elementoActual.getNumeroPresupuestos() > 0 ? "Tienes " + elementoActual.getNumeroPresupuestos() + " presupuesto/s" : "No tienes presupuestos"));

        if(elementoActual.getUrlFoto() != null && !elementoActual.getUrlFoto().isEmpty()) {
            Glide.with(this.ctx)
                    .load(elementoActual.getUrlFoto())
                    .into(imageAveria);
        }

        return v;
    }
}
