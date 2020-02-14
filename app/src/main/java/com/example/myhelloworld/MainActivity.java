package com.example.myhelloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    //int images[];

    private RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rview);
        myAdapter = new MyAdapter(this, GlobalArrays.narucitelji, GlobalArrays.vozila,
                GlobalArrays.lokacija);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, DetailsActivity.class), 1);

            }
        });

        recyclerView.setAdapter(myAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

        //mAdapter = new MyAdapter(myDataset);
        //recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == 1){
        super.onActivityResult(requestCode, resultCode, data);
        myAdapter.lokacija.add(data.getStringExtra("lokacija"));
        myAdapter.vozila.add(data.getStringExtra("vozilo"));
        myAdapter.narucitelji.add(data.getStringExtra("narucitelj"));
        //myAdapter.notifyDataSetChanged();
        myAdapter.notifyItemInserted(myAdapter.narucitelji.size()-1);

    }

    }
}
