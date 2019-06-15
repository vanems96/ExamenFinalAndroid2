package com.example.examenfinalandroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.ViewHolder> {

    ArrayList<String> alumnos;

    public AlumnoAdapter(ArrayList<String> alumnos) {
        this.alumnos = alumnos;
    }

    @NonNull
    @Override
    public AlumnoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.alumno_row,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoAdapter.ViewHolder viewHolder, int i) {
        viewHolder.lblNombre.setText(alumnos.get(i));
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView lblNombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lblNombre = itemView.findViewById(R.id.lblNombre);
        }
    }
}
