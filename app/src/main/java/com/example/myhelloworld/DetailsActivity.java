package com.example.myhelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {
    EditText lokacija_edit;
    EditText vozilo_edit;
    EditText narucitelj_edit;
    EditText napomena_edit;
    int RESULT_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        lokacija_edit = (EditText) findViewById(R.id.lokacija);
        vozilo_edit = (EditText) findViewById(R.id.vozilo);
        narucitelj_edit = (EditText) findViewById(R.id.narucitelj);
        napomena_edit = (EditText) findViewById(R.id.napomena);
        Button dodaj_intervenciju = (Button) findViewById(R.id.bt_submit_intervention);
        dodaj_intervenciju.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                RESULT_CODE = 1;
                DetailsActivity.this.finish();
            }

        });

    }

    @Override
    public void finish() {
        String vozilo = vozilo_edit.getText().toString();
        String lokacija = lokacija_edit.getText().toString();
        String narucitelj = narucitelj_edit.getText().toString();
        String napomena = napomena_edit.getText().toString();
        if (RESULT_CODE == 1) GlobalArrays.napomena.add(napomena);
        Intent intent = new Intent();
        intent.putExtra("vozilo", vozilo);
        intent.putExtra("lokacija", lokacija);
        intent.putExtra("narucitelj", narucitelj);
        setResult(RESULT_CODE, intent);
        super.finish();
    }
}
