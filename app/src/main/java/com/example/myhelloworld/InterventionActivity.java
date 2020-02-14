package com.example.myhelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InterventionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervention);
        TextView view = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String vozilo = intent.getStringExtra("vozilo");
        String lokacija = intent.getStringExtra("lokacija");
        String narucitelj = intent.getStringExtra("narucitelj");
        view.setText(vozilo + " " + narucitelj + " " + lokacija);
    }
}
