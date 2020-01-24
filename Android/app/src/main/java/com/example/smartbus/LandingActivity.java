package com.example.smartbus;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.ACCESS_WIFI_STATE;

public class LandingActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 200;
    private View view;
    int i = 1;
    public static final String GOOGLE_ACCOUNT = "google_account";
    String message="";

    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        startService(new Intent(this, MyService.class));

        if (!checkPermission()) {

            requestPermission();

        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        String phno = "tel:";
                Snackbar.make(view, "Calling your emergency contact...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//CHECK FOR PERMISSION

//                Intent intent = new Intent(Intent.ACTION_CALL);
//                intent.setData(Uri.parse(phno));
//                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//
//                    return;
//                }
//                startActivity(intent);
                String eNo = "9980950485";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + eNo));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(intent);
            }


        });
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, new LocationListener() {
            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {}
            @Override
            public void onProviderEnabled(String s) {}
            @Override
            public void onProviderDisabled(String s) {}
            @Override
            public void onLocationChanged(final Location location) {}
        });
        Location myLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        double longitude = myLocation.getLongitude();
        double latitude = myLocation.getLatitude();

        message+="http://maps.google.com/maps?q="+latitude+","+longitude;


        FloatingActionButton fab1 = findViewById(R.id.fab2);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String phno = "tel:";
                Snackbar.make(view, "Texting your favourite contacts", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                String smsNumber = "7250996657";
                String smsText = "It is an emergency.pls help!!My current location\n"+message;

                Uri uri = Uri.parse("smsto:" + smsNumber);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", smsText);
                startActivity(intent);

            }

        });
    }


    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_WIFI_STATE);

        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION, ACCESS_WIFI_STATE}, PERMISSION_REQUEST_CODE);

    }


    public void fn1(View view) {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
    }

    public void fn2(View view) {
        Uri uriUrl = Uri.parse("https://poojak97.github.io/Payment/");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void fn3(View view) {
        WifiManager wifiMgr = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
        if (wifiInfo.getBSSID()!=null) {
            if (wifiInfo.getBSSID().equals("7c:95:f3:73:1f:89")) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), "Connect to our WiFi and then try", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Connect to our WiFi and then try", Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
    }

    public void fn4(View view) {
        Intent intent = new Intent(getApplicationContext(), SecurityActivity.class);
        startActivity(intent);
    }

    public void fn5(View view) {
                if (i==1) {
                    stopService(new Intent(getApplicationContext(), MyService.class));
                    i=0;
                }
                else {
                    startService(new Intent(getApplicationContext(), MyService.class));
                    i=1;
                }
    }

    public void fn6(View view) {
        Uri uriUrl = Uri.parse("https://www.hackathon.com/event/nmit-hacks-2020-5dcd86f81ddca0001b3dd5ce");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
