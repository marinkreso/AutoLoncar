package com.example.myhelloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context ct;
    public ArrayList<String> vozila;
    public ArrayList<String> narucitelji;
    public ArrayList<String> lokacija;

     MyAdapter(Context ct, ArrayList<String> narucitelji, ArrayList<String> vozila, ArrayList<String> lokacija) {

        this.ct = ct;
        this.narucitelji = narucitelji;
        this.vozila = vozila;
        this.lokacija = lokacija;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        String informacija = String.format("Narucitelj: %s, Vozilo: %s, Lokacija: %s",
                narucitelji.get(position), vozila.get(position), lokacija.get(position));
        holder.informacije.setText(informacija);
        holder.intervencija.setText("Intervencija " + position);
    }

    @Override
    public int getItemCount() {
        return narucitelji.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView intervencija, informacije;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            intervencija = itemView.findViewById(R.id.intervencija);
            informacije = itemView.findViewById(R.id.informacije);
        }
    }
}
