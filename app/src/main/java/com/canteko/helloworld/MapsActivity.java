package com.canteko.helloworld;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.canteko.helloworld.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Arrays;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;
    private Circle circle;
    private ActivityMapsBinding binding;
    private LatLng posicionAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng cordoba = new LatLng(37.892, -4.782);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cordoba));
        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMarkerDragListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cordoba, 13));

        // Definicion del circulo
        CircleOptions circleOptions = new CircleOptions()
                .center(cordoba)
                .fillColor(ContextCompat.getColor(this, R.color.transparentOrange))
                .strokeColor(ContextCompat.getColor(this, R.color.orange))
                .strokeWidth(5)
                .radius(1000);

        circle = mMap.addCircle(circleOptions);
    }

    public void changeMapType(View view) {
        List<Integer> mapTypes = Arrays.asList(GoogleMap.MAP_TYPE_NONE, GoogleMap.MAP_TYPE_NORMAL, GoogleMap.MAP_TYPE_SATELLITE, GoogleMap.MAP_TYPE_TERRAIN, GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMapType((mMap.getMapType() + 1) % 5);
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("Marker in " + latLng.toString())
                .draggable(true)
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_baseline_arrow_downward_24))
        );

        if(posicionAnterior != null) {
            PolylineOptions polylineOptions = new PolylineOptions()
                    .add(posicionAnterior)
                    .add(latLng);

            Polyline polyline = mMap.addPolyline(polylineOptions);
        }

        circle.setCenter(latLng);
        posicionAnterior = latLng;
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, @DrawableRes int vectorDrawableResourceId) {
        Drawable drawable = ContextCompat.getDrawable(context, vectorDrawableResourceId);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        Toast.makeText(this, "Has hecho click en el marker " + marker.getId(), Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onMarkerDragStart(@NonNull Marker marker) {
        Toast.makeText(this, "Arrastra", Toast.LENGTH_SHORT).show();
        marker.hideInfoWindow();
    }

    @Override
    public void onMarkerDrag(@NonNull Marker marker) {
        Log.d(":::MARKER", marker.getPosition().toString());
    }

    @Override
    public void onMarkerDragEnd(@NonNull Marker marker) {
        Toast.makeText(this, "Suelta", Toast.LENGTH_SHORT).show();
        marker.showInfoWindow();
    }
}