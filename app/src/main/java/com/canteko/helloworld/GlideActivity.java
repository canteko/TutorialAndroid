package com.canteko.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class GlideActivity extends AppCompatActivity {

    ImageView logotipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        RequestOptions cropOptions = new RequestOptions().fitCenter();

        logotipo = (ImageView) findViewById(R.id.imageViewGlide);
        Glide.with(this)
                .load("https://static0.srcdn.com/wordpress/wp-content/uploads/2020/07/kratos-god-of-war-.jpg")
                .apply(cropOptions)
                .into(logotipo);
    }
}