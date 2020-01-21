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
        arrayList.add("Hebbal");
        arrayList.add("BEL Circle");
        arrayList.add("Gokula");
        arrayList.add("Matthikere");
        arrayList.add("Ramaiah College");
        arrayList.add("Yesvantpur");
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
        arrayList1.add("Hebbal");
        arrayList1.add("BEL Circle");
        arrayList1.add("Gokula");
        arrayList1.add("Matthikere");
        arrayList1.add("Ramaiah College");
        arrayList1.add("Yesvantpur");
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

        //mMap.addPolyline(p.add(Bus500D).add(Bus500BA).add(MatthikereStop).color(Color.GREEN).geodesic(true));
        //mMap.addPolyline(p1.add(Bus500).add(MatthikereStop).color(Color.GREEN).geodesic(true));

    }
}
