package com.canteko.helloworld;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.canteko.helloworld.placeholder.PlaceholderContent;

import java.util.ArrayList;
import java.util.List;

public class AveriaElementFragment extends Fragment {

    private OnAveriaInteractionListener mListener;
    private List<Averia> averiasList = new ArrayList<>();;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list2, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            averiasList.add(new Averia("asdasd", "asdasdas", "https://static1.elcorreo.com/www/multimedia/202101/11/media/cortadas/apple-car-icar-kcWG-U130183090282s2E-624x385@El%20Correo.jpg", 0));
            averiasList.add(new Averia("as4535d", "asdasdas", "https://static1.elcorreo.com/www/multimedia/202101/11/media/cortadas/apple-car-icar-kcWG-U130183090282s2E-624x385@El%20Correo.jpg", 5));
            averiasList.add(new Averia("as345d", "asdasdas", "", 2));
            averiasList.add(new Averia("as123sd", "asdasdas", "", 0));
            averiasList.add(new Averia("a65sd", "asdasdas", "https://static1.elcorreo.com/www/multimedia/202101/11/media/cortadas/apple-car-icar-kcWG-U130183090282s2E-624x385@El%20Correo.jpg", 3));
            averiasList.add(new Averia("345d", "asdasdas", "", 1));

            recyclerView.setAdapter(new MyAveriaElementRecyclerViewAdapter(getActivity(), averiasList, mListener));
        }
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnAveriaInteractionListener) {
            mListener = (OnAveriaInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnAveriaInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}