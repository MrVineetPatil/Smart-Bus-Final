package com.example.smartbus;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker m1;
    private Marker m2;
    private Marker m;
    int p = 0;
    int p1= 0;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Switch s = findViewById(R.id.switch1);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i==1) {
                    i=0;
                }
                else {
                    i=1;
                }
            }
        });

        Spinner spinner = findViewById(R.id.option);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Select Source!");
        arrayList.add("NMIT Bus Stand");
        arrayList.add("Harohalli");
        arrayList.add("Gantaganahalli");
        arrayList.add("Nagenahalli");
        arrayList.add("Nagenahalli Gate");
        arrayList.add("CPRI");
        arrayList.add("CS-Heritage Estate");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName, Toast.LENGTH_LONG).show();
                p = position;
                if (p1!=0 && p!=0) {
                    if (i==0) {
                        Intent intent = new Intent(getApplicationContext(), TrackActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(), TrackActivity2.class);
                        startActivity(intent);
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        Spinner spinner1 = findViewById(R.id.option1);
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Select Destination!");
        arrayList1.add("NMIT Bus Stand");
        arrayList1.add("Harohalli");
        arrayList1.add("Gantaganahalli");
        arrayList1.add("Nagenahalli");
        arrayList1.add("Nagenahalli Gate");
        arrayList1.add("CPRI");
        arrayList1.add("CS-Heritage Estate");
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName, Toast.LENGTH_LONG).show();
                p1=position;
                if (p1!=0 && p!=0) {
                    if (i==0) {
                        Intent intent = new Intent(getApplicationContext(), TrackActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(), TrackActivity2.class);
                        startActivity(intent);
                    }
                }

            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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
        LatLng l1 = new LatLng(13.128665, 77.587372);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(l1));
        mMap.setMaxZoomPreference(17f);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        mMap.addMarker(new MarkerOptions().position(l1).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.bus)
        ).title("NITT-2 BUS, ETA: 13:00"));

        LatLng l2 = new LatLng(13.128662, 77.587370);
        mMap.addMarker(new MarkerOptions().position(l2).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.bus)
        ).title("NITT-1 BUS, ETA: 13:30"));

        LatLng BusNITT_2 = new LatLng(13.131092, 77.590195);
        mMap.addMarker(new MarkerOptions().position(BusNITT_2).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop1)
        ).title("NMIT Bus Stand"));

        LatLng Harohalli = new LatLng(13.13072, 77.580218);
        mMap.addMarker(new MarkerOptions().position(Harohalli).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Harohalli"));

        LatLng Gantaganahalli = new LatLng(13.143879, 77.588664);
        mMap.addMarker(new MarkerOptions().position(Gantaganahalli).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Gantaganahalli"));

        LatLng Nagenahalli = new LatLng(13.132118, 77.574804);
        mMap.addMarker(new MarkerOptions().position(Nagenahalli).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Nagenahalli"));

        LatLng Nagenahalli_Gate = new LatLng(13.130729, 77.571594);
        mMap.addMarker(new MarkerOptions().position(Nagenahalli_Gate).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Nagenahalli Gate"));

        LatLng CPRI = new LatLng(13.125531, 77.571717);
        mMap.addMarker(new MarkerOptions().position(CPRI).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("CPRI"));

        LatLng CS_Heritage_Estate = new LatLng(13.119464, 77.577454);
        mMap.addMarker(new MarkerOptions().position(CS_Heritage_Estate).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("CS-Heritage Estate"));

    }
}
