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
        TextView tvVozilo = (TextView) findViewById(R.id.tv_vozilo);
        TextView tvNapomena = (TextView) findViewById(R.id.tv_napomena);
        TextView tvLokacija = (TextView) findViewById(R.id.tv_lokacija);
        TextView tvNarucitelj = (TextView) findViewById(R.id.tv_narucitelj);

        Intent intent = getIntent();

        String vozilo = intent.getStringExtra("vozilo");
        String lokacija = intent.getStringExtra("lokacija");
        String narucitelj = intent.getStringExtra("narucitelj");
        String napomena = intent.getStringExtra("napomena");

        tvVozilo.setText("VOZILO: " + vozilo);
        tvNapomena.setText(napomena);
        tvLokacija.setText("LOKACIJA: " + lokacija);
        tvNarucitelj.setText("NARUCITELJ: " + narucitelj);
    }
}
