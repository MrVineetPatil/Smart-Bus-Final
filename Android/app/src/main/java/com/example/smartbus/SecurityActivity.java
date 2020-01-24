package com.example.smartbus;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

public class SecurityActivity extends  AppCompatActivity {
    String mOption;
    private int mYear, mMonth, mDay;
    String mBus;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    ImageView chooseDate;
    TextView d1;
    TextView mt;
    TextView mt1;
    TextView dt;
    TextView dt1;
    String da, t1, t2;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText x = findViewById(R.id.editText2);

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

        chooseDate=findViewById(R.id.cal);
        d1 = findViewById(R.id.textView);

        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                
                datePickerDialog = new DatePickerDialog(SecurityActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                da = (dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                                d1.setText(da);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        dt = findViewById(R.id.date);
        mt = findViewById(R.id.text1);
        dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(SecurityActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        t1 = String.format("%02d:%02d", hourOfDay, minutes) + amPm;
                        mt.setText(t1);

                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });

        dt1 = findViewById(R.id.date1);
        mt1 = findViewById(R.id.t1);
        dt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(SecurityActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        t2 = String.format("%02d:%02d", hourOfDay, minutes) + amPm;
                        mt1.setText(t2);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });

        Button b = findViewById(R.id.add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.child("Complaints").child(mOption).child("2").child("Bus_no").setValue(mBus);
                mDatabase.child("Complaints").child(mOption).child("2").child("Date").setValue(da);
                mDatabase.child("Complaints").child(mOption).child("2").child("Description").setValue(x.getText().toString());
                mDatabase.child("Complaints").child(mOption).child("2").child("End").setValue(t2);
                mDatabase.child("Complaints").child(mOption).child("2").child("Start").setValue(t1);
                Toast toast = Toast.makeText(getApplicationContext(), "Complaint Registered", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showDatePicker (View v){
            DialogFragment newFragment = new MyDatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "date picker");
        }

    }
