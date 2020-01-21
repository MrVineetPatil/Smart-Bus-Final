package com.example.smartbus;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartbus.directionhelpers.TaskLoadedCallback;
import com.example.smartbus.directionhelpers.fetchurl;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class RouteActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private Marker m1;
    private Marker m2;
    private Marker m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routeactivity);


        Routes[] myListData = new Routes[] {
                new Routes("Hebbal", "5/50"),
                new Routes("BEL Circle", "0/50"),
                new Routes("Gokula", "10/50"),
                new Routes("Matthikere", "15/50"),
                new Routes("Ramaiah College", "12/50"),
                new Routes("Yesvantpur", "0/50")
        };

        RecyclerView recyclerView = findViewById(R.id.recyclerViewRoutes1);
        RoutesAdapter adapter = new RoutesAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng MatthikereStop = new LatLng(13.1, 77.33);
        m = mMap.addMarker(new MarkerOptions().position(MatthikereStop).title("Matthikere Bus Stop"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MatthikereStop));
        mMap.setMaxZoomPreference(13f);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13));

        LatLng Bus500 = new LatLng(13.15, 77.33);
        mMap.addMarker(new MarkerOptions().position(Bus500).icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
        ).title("500, ETA: 8:20am"));

        LatLng Bus500BA = new LatLng(13.12, 77.3121);
        mMap.addMarker(new MarkerOptions().position(Bus500BA).icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
        ).title("500BA, ETA: 8:05am"));

        LatLng Bus500D = new LatLng(13.1345, 77.3122);
        mMap.addMarker(new MarkerOptions().position(Bus500D).icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
        ).title("500D, ETA: 8:15am"));

        PolylineOptions p = new PolylineOptions();
        PolylineOptions p1 = new PolylineOptions();

        mMap.addPolyline(p.add(Bus500D).add(Bus500BA).add(MatthikereStop).color(Color.GREEN).geodesic(true));
        mMap.addPolyline(p1.add(Bus500).add(MatthikereStop).color(Color.GREEN).geodesic(true));

    }
}
