package com.example.examenfinalandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FechaAdapter extends RecyclerView.Adapter<FechaAdapter.ViewHolder> {

    List<Fecha> fechas;

    public FechaAdapter(List<Fecha> fechas) {
        this.fechas = fechas;
    }

    @NonNull
    @Override
    public FechaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fecha_row,parent,false);
        return new FechaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FechaAdapter.ViewHolder holder, int position) {

        holder.idFecha.setText(fechas.get(position).getNumFecha()+"");
        holder.fecha.setText(fechas.get(position).getFechaMed()+"");
        holder.porcentajeDeGrasa.setText(fechas.get(position).getPorcentajeGra()+"");
        holder.porcentajeMasaMuscular.setText(fechas.get(position).getMasaMuscular()+"");
        holder.pesoEnKilogramos.setText(fechas.get(position).getPesoKg()+"");
        holder.edadMetabolica.setText(fechas.get(position).getEdadMeta()+"");


    }

    @Override
    public int getItemCount() {
        return fechas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView idFecha;
        public TextView fecha;
        public TextView porcentajeDeGrasa;
        public TextView porcentajeMasaMuscular;
        public TextView pesoEnKilogramos;
        public TextView edadMetabolica;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idFecha = itemView.findViewById(R.id.idFecha);
            fecha = itemView.findViewById(R.id.Fecha);
            porcentajeDeGrasa = itemView.findViewById(R.id.porcentaje_grasa);
            porcentajeMasaMuscular = itemView.findViewById(R.id.porcentaje_masa_muscular);
            pesoEnKilogramos = itemView.findViewById(R.id.peso_kg);
            edadMetabolica = itemView.findViewById(R.id.edad_metabolica);
        }
    }
}
