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
                new Routes("NMIT Bus Stand", "5/50"),
                new Routes("Harohalli", "0/50"),
                new Routes("Ganataganahalli", "10/50"),
                new Routes("Nagenahalli", "15/50"),
                new Routes("Nagenahalli Gate", "12/50"),
                new Routes("CPRI", "0/50"),
                new Routes("CS-Heritage Estate", "12/50")
        };

        RecyclerView recyclerView = findViewById(R.id.recyclerViewRoutes1);
        RoutesAdapter adapter = new RoutesAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng NITT_BUS = new LatLng(13.128665, 77.587372);
//        m = mMap.addMarker(new MarkerOptions().position(NITT_BUS).icon(
//                BitmapDescriptorFactory.fromResource(R.drawable.bus)
//        ).title("NITT BUS"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(NITT_BUS));
        mMap.setMaxZoomPreference(15f);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13));

        LatLng NMIT_Bus_Stand = new LatLng(13.131092, 77.590195);
        mMap.addMarker(new MarkerOptions().position(NMIT_Bus_Stand).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("NMIT Bus Stand, 5/50"));

        LatLng Harohalli = new LatLng(13.13072, 77.580218);
        mMap.addMarker(new MarkerOptions().position(Harohalli).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop1)
        ).title("Harohalli, 0/50"));

//        LatLng Gantaganahalli = new LatLng(13.143879, 77.588664);
//        mMap.addMarker(new MarkerOptions().position(Gantaganahalli).icon(
//                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
//        ).title("Gantaganahalli, 10/50"));

        LatLng Nagenahalli = new LatLng(13.132118, 77.574804);
        mMap.addMarker(new MarkerOptions().position(Nagenahalli).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Nagenahalli, 15/50"));

        LatLng Nagenahalli_Gate = new LatLng(13.130729, 77.571594);
        mMap.addMarker(new MarkerOptions().position(Nagenahalli_Gate).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Nagenahalli Gate, 12/20"));

        LatLng CPRI = new LatLng(13.125531, 77.571717);
        mMap.addMarker(new MarkerOptions().position(CPRI).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop1)
        ).title("CPRI, 0/20"));

        LatLng CS_Heritage_Estate = new LatLng(13.119464, 77.577454);
        mMap.addMarker(new MarkerOptions().position(CS_Heritage_Estate).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("CS-Heritage Estate, 50/50"));

        PolylineOptions p = new PolylineOptions();
        PolylineOptions p1 = new PolylineOptions();
        PolylineOptions p2 = new PolylineOptions();

        mMap.addPolyline(p1.add(NMIT_Bus_Stand).add(Harohalli).color(Color.BLACK).geodesic(true));
        mMap.addPolyline(p2.add(CPRI).add(CS_Heritage_Estate).color(Color.BLACK).geodesic(true));
        mMap.addPolyline(p.add(Harohalli).add(Nagenahalli).add(Nagenahalli_Gate).add(CPRI).color(Color.BLUE).geodesic(true));

    }
}
