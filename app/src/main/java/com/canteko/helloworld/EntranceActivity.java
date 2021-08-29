package com.canteko.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_HelloWorld);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
    }

    public void goToMainActivity(View view) {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    public void goToPicassoActivity(View view) {
        Intent picassoActivity = new Intent(this, PicassoActivity.class);
        startActivity(picassoActivity);
    }

    public void goToGlideActivity(View view) {
        Intent glideActivity = new Intent(this, GlideActivity.class);
        startActivity(glideActivity);
    }

    public void goToConstraintLayoutActivity(View view) {
        Intent intent = new Intent(this, ConstraintLayoutActivity.class);
        startActivity(intent);
    }

    public void goToFragemntActivity(View view) {
        Intent intent = new Intent(this, FragmentActivity.class);
        startActivity(intent);
    }

    public void goToDynamicFragmentActivity(View view) {
        Intent intent = new Intent(this, DynamicFragmentActivity.class);
        startActivity(intent);
    }

    public void goToFragmentListActivity(View view) {
        Intent intent = new Intent(this, FragmentListActivity.class);
        startActivity(intent);
    }

    public void goToComunicatedFragmentsActivity(View view) {
        Intent intent = new Intent(this, ComunicatedFragmentsActivity.class);
        startActivity(intent);
    }

    public void goToMultiscreenActivity(View view) {
        Intent intent = new Intent(this, MultiscreenActivity.class);
        startActivity(intent);
    }

    public void goToMultiscreenTabletsActivity(View view) {
        Intent intent = new Intent(this, MultiscreenTabletsActivity.class);
        startActivity(intent);
    }

    public void goToDialogActivity(View view) {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);
    }

    public void goToMenuActivity(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void goToNavigationDrawerActivity(View view) {
        Intent intent = new Intent(this, NavigationDrawerActivity.class);
        startActivity(intent);
    }
}