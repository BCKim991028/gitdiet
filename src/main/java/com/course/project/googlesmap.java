package com.course.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.icu.lang.UScript;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class googlesmap extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.googlemap);
        Button main_btn = (Button) findViewById(R.id.main_btn);
        main_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){
            @Override
            public void onMapClick(LatLng point) {
                MarkerOptions mOptions = new MarkerOptions();
                // 마커 타이틀
                mOptions.title("마커 좌표");
                Double latitude = point.latitude; // 위도
                Double longitude = point.longitude; // 경도
                Intent intent = new Intent(googlesmap.this, MainActivity.class);
                intent.putExtra("위도", latitude );
                intent.putExtra("경도", longitude);
                startActivity(intent);

                mOptions.snippet(latitude.toString() + ", " + longitude.toString());
                mOptions.position(new LatLng(latitude, longitude));

                googleMap.addMarker(mOptions);
            }
        });
        LatLng sydney = new LatLng(37.56, 126.97);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Seoul"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


}
