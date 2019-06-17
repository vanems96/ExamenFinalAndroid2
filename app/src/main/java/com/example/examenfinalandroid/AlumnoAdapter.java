package com.example.examenfinalandroid;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.ViewHolder> implements View.OnClickListener{

    List<Alumno> alumnos;

    private View.OnClickListener clickListener;
    private View.OnLongClickListener longClickListener;

    public AlumnoAdapter(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @NonNull
    @Override
    public AlumnoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.alumno_row,viewGroup,false);

        view.setOnClickListener(this);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoAdapter.ViewHolder viewHolder, int i) {
        viewHolder.lblNombre.setText(alumnos.get(i).getNombre());
        viewHolder.lblEdad.setText(alumnos.get(i).getEdad());
        viewHolder.lblEmail.setText(alumnos.get(i).getEmail());
        viewHolder.lblId.setText(alumnos.get(i).getId());
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public void setClickListener(View.OnClickListener listener){
        this.clickListener = listener;
    }

    @Override
    public void onClick(View v) {
        if(clickListener!= null){
            clickListener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView lblNombre;
        public TextView lblEdad;
        public TextView lblEmail;
        public TextView lblId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblEdad = itemView.findViewById(R.id.lblEdad);
            lblEmail = itemView.findViewById(R.id.lblEmail);
            lblId = itemView.findViewById(R.id.lblId);

        }
    }
}
