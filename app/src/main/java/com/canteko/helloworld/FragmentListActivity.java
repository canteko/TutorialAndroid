package com.canteko.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FragmentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_list);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_list, new AveriaFragment().newInstance(2))
                .commit();
    }
}