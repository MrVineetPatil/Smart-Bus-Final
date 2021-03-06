package com.example.smartbus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.TimePickerDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.DatePicker;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.Calendar;

public class TrackActivity extends AppCompatActivity {

    ImageView chooseTime;
    ImageView chooseDate;
    TextView mt;
    TextView mt1;
    TextView d1;
    ImageView chooseTime1;
    TimePickerDialog timePickerDialog;
    DatePickerDialog datePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        Bus[] myListData = new Bus[] {
                new Bus("NITT-2"),
                new Bus("285-A"),
                new Bus("285"),
                new Bus("285-AA"),
                new Bus("285-C"),
                new Bus("285-CA"),
                new Bus("BMSIT-4"),
        };

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ListAdapter adapter = new ListAdapter(getApplicationContext(), myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        chooseDate=findViewById(R.id.cal);
        d1 = findViewById(R.id.t);

        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog


                datePickerDialog = new DatePickerDialog(TrackActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                d1.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });



        chooseTime = findViewById(R.id.time1);
        mt = findViewById(R.id.t1);
        chooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(TrackActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        mt.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);

                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });
        mt1 = findViewById(R.id.t2);
        chooseTime1 = findViewById(R.id.time2);
        chooseTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(TrackActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        mt1.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);

                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}