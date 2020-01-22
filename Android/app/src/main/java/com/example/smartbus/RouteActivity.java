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
        LatLng NMIT = new LatLng(13.128665, 77.587372);
        m = mMap.addMarker(new MarkerOptions().position(NMIT).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop1)
        ).title("NMIT college"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(NMIT));
        mMap.setMaxZoomPreference(13f);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13));

        LatLng BusNITT_2 = new LatLng(13.131092, 77.590195);
        mMap.addMarker(new MarkerOptions().position(BusNITT_2).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.bus)
        ).title("NMIT Bus Stand"));

        LatLng Bus285_A = new LatLng(13.13072, 77.580218);
        mMap.addMarker(new MarkerOptions().position(Bus285_A).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Harohalli"));

        LatLng BusNITT_21 = new LatLng(13.13072, 77.580218);
        mMap.addMarker(new MarkerOptions().position(BusNITT_21).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Harohalli"));

        LatLng BusNITT_22 = new LatLng(13.143879, 77.588664);
        mMap.addMarker(new MarkerOptions().position(BusNITT_22).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Gantaganahalli"));

        LatLng BusNITT_23 = new LatLng(13.132118, 77.574804);
        mMap.addMarker(new MarkerOptions().position(BusNITT_23).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Nagenahalli"));

        LatLng Bus285_A1 = new LatLng(13.132118, 77.574804);
        mMap.addMarker(new MarkerOptions().position(Bus285_A1).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Nagenahalli"));

        LatLng BusNITT_24 = new LatLng(13.130729, 77.571594);
        mMap.addMarker(new MarkerOptions().position(BusNITT_24).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Nagenahalli Gate"));

        LatLng Bus285 = new LatLng(13.130729, 77.571594);
        mMap.addMarker(new MarkerOptions().position(Bus285).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Nagenahalli Gate"));

        LatLng Bus285_A2 = new LatLng(13.130729, 77.571594);
        mMap.addMarker(new MarkerOptions().position(Bus285_A2).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Nagenahalli Gate"));

        LatLng Bus285_AA = new LatLng(13.130729, 77.571594);
        mMap.addMarker(new MarkerOptions().position(Bus285_AA).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Nagenahalli Gate"));

        LatLng Bus285_C = new LatLng(13.130729, 77.571594);
        mMap.addMarker(new MarkerOptions().position(Bus285_C).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Nagenahalli Gate"));

        LatLng Bus285_1 = new LatLng(13.24575, 77.574804);
        mMap.addMarker(new MarkerOptions().position(Bus285_1).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("CPRI"));

        LatLng Bus285_A3 = new LatLng(13.24575, 77.574804);
        mMap.addMarker(new MarkerOptions().position(Bus285_A3).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("CPRI"));

        LatLng Bus285_AA1 = new LatLng(13.24575, 77.574804);
        mMap.addMarker(new MarkerOptions().position(Bus285_AA1).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("CPRI"));

        LatLng Bus285_C1 = new LatLng(13.24575, 77.574804);
        mMap.addMarker(new MarkerOptions().position(Bus285_C1).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("CPRI"));

        LatLng Bus285_CA = new LatLng(13.24575, 77.574804);
        mMap.addMarker(new MarkerOptions().position(Bus285_CA).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("CPRI"));

        LatLng BusBMSIT_4 = new LatLng(13.119464, 77.577454);
        mMap.addMarker(new MarkerOptions().position(BusBMSIT_4).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("CS-Heritage Estate"));

        PolylineOptions p = new PolylineOptions();
        PolylineOptions p1 = new PolylineOptions();

        mMap.addPolyline(p.add(NMIT).add(BusNITT_2).add(Bus285_A).add(Bus285_AA).add(Bus285_CA).add(BusBMSIT_4).color(Color.GREEN).geodesic(true));
        mMap.addPolyline(p.add(NMIT).add(BusNITT_2).add(Bus285_AA).add(Bus285_CA).add(BusBMSIT_4).color(Color.GREEN).geodesic(true));

    }
}
