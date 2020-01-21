package com.example.smartbus;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecurityActivity extends  AppCompatActivity {
    String mOption;
    private int mYear, mMonth, mDay;
    String mBus;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //DatabaseReference mRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://smartbus-7f56a.firebaseio.com/");

        Spinner spinner1 = findViewById(R.id.option);
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Harassment");
        arrayList1.add("Property Loss");
        arrayList1.add("Bus Related Complaints");
        arrayList1.add("Others");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mOption = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner spinner2 = findViewById(R.id.bus);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("401K");
        arrayList2.add("500BA");
        arrayList2.add("335B");
        arrayList2.add("276");
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mBus = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Button b = findViewById(R.id.add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
                startActivity(intent);
                JSONObject obj = new JSONObject();
                try {
                    obj.put("bus_no", mBus);
                    obj.put("problem", mOption);
                    obj.put("d", mDay);
                    obj.put("m", mMonth);
                    obj.put("y", mYear);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mDatabase.child("complaints").setValue(obj)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Context context = getApplicationContext();
                                CharSequence text = "Added to firebase";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Context context = getApplicationContext();
                                CharSequence text = "not Added to firebase";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }
                        });
            }
        });


    }



    public void showDatePicker (View v){
            DialogFragment newFragment = new MyDatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "date picker");
        }

    }
