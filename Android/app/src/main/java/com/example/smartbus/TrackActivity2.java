package com.example.smartbus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class TrackActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track2);

        Bus[] myListData = new Bus[] {
                new Bus("NITT-2"),
                new Bus("285-A"),
                new Bus("285"),
                new Bus("285-AA"),
                new Bus("285-C"),
                new Bus("285-CA"),
                new Bus("BMSIT-4"),
        };

        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        ListAdapter1 adapter = new ListAdapter1(getApplicationContext(), myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
