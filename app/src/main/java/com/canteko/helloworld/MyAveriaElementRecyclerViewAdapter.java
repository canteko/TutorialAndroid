package com.canteko.helloworld;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.canteko.helloworld.databinding.AveriaItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Averia}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyAveriaElementRecyclerViewAdapter extends RecyclerView.Adapter<MyAveriaElementRecyclerViewAdapter.ViewHolder> {

    private final List<Averia> mValues;
    private OnAveriaInteractionListener mListener;
    private Context ctx;

    public MyAveriaElementRecyclerViewAdapter(Context context, List<Averia> items, OnAveriaInteractionListener listener) {
        this.ctx = context;
        this.mValues = items;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(AveriaItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewTitulo.setText(holder.mItem.getTitulo());
        holder.textViewModeloCoche.setText(holder.mItem.getModeloCoche());
        holder.textViewPresupuestos.setText("Presupuestos: " + holder.mItem.getNumeroPresupuestos());

        if(holder.mItem.getUrlFoto() != null && !holder.mItem.getUrlFoto().isEmpty()) {
            Glide.with(this.ctx)
                    .load(holder.mItem.getUrlFoto())
                    .into(holder.fotoAveria);
        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textViewTitulo;
        public final TextView textViewModeloCoche;
        public final TextView textViewPresupuestos;
        public final ImageView fotoAveria;
        public Averia mItem;

        public ViewHolder(AveriaItemBinding binding) {
            super(binding.getRoot());
            textViewTitulo = binding.getRoot().findViewById(R.id.textViewAveriaTitulo);
            textViewModeloCoche = binding.getRoot().findViewById(R.id.textViewModeloCocheAveria);
            textViewPresupuestos = binding.getRoot().findViewById(R.id.textViewPresupuestos);
            fotoAveria = binding.getRoot().findViewById(R.id.imageViewPhoto);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewTitulo.getText() + "'";
        }
    }
}