package com.example.smartbus;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class TabThree extends Fragment implements OnMapReadyCallback {

    SupportMapFragment mapFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_three, container, false);
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment==null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap mMap) {

        // Add a marker in Sydney and move the camera
        LatLng MatthikereStop = new LatLng(13.28665, 77.587372);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MatthikereStop));
        mMap.setMaxZoomPreference(13f);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));

        LatLng NITT_BUS = new LatLng(13.128665, 77.587372);
//        m = mMap.addMarker(new MarkerOptions().position(NITT_BUS).icon(
//                BitmapDescriptorFactory.fromResource(R.drawable.bus)
//        ).title("NITT BUS"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(NITT_BUS));
        mMap.setMaxZoomPreference(15f);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13));

        LatLng NMIT_Bus_Stand = new LatLng(13.131092, 77.590195);
        mMap.addMarker(new MarkerOptions().position(NMIT_Bus_Stand).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop1)
        ).title("CS-Heritage Estate, 50/50"));

        LatLng Harohalli = new LatLng(13.13072, 77.580218);

        LatLng Nagenahalli = new LatLng(13.132118, 77.574804);
        mMap.addMarker(new MarkerOptions().position(Nagenahalli).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.bus)
        ).title("Nagenahalli, 15/50"));

        LatLng Nagenahalli_Gate = new LatLng(13.130729, 77.571594);
        mMap.addMarker(new MarkerOptions().position(Nagenahalli_Gate).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("Nagenahalli Gate, 12/20"));

        LatLng CPRI = new LatLng(13.125531, 77.571717);
        mMap.addMarker(new MarkerOptions().position(CPRI).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop)
        ).title("CPRI, 0/20"));

        LatLng CS_Heritage_Estate = new LatLng(13.119464, 77.577454);
        mMap.addMarker(new MarkerOptions().position(CS_Heritage_Estate).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.busstop1)
        ).title("CS-Heritage Estate, 50/50"));

        PolylineOptions p = new PolylineOptions();
        PolylineOptions p1 = new PolylineOptions();
        PolylineOptions p2 = new PolylineOptions();

        mMap.addPolyline(p2.add(Nagenahalli).add(Nagenahalli_Gate).add(CPRI).add(CS_Heritage_Estate).color(Color.BLUE).geodesic(true));
        mMap.addPolyline(p.add(NMIT_Bus_Stand).add(Harohalli).add(Nagenahalli).color(Color.GREEN).geodesic(true));

    }
}
