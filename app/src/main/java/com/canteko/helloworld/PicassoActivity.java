package com.canteko.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoActivity extends AppCompatActivity {

    ImageView logotipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        logotipo = (ImageView) findViewById(R.id.imageViewLogotipo);
        Picasso.get()
                .load("https://media.vandalimg.com/common/960x720/20085104714.jpg")
                .resize(1080, 1920)
                .placeholder(R.drawable.ic_baseline_image_24)
                .centerCrop()
                .into(logotipo);

    }
}