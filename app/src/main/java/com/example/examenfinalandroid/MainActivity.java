package com.example.examenfinalandroid;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewAlumnos;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Prepara la Conexion a la DB
        AppDatabase bd = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "datosAlumnos")
                .allowMainThreadQueries()
                .build();

        //Rellena una lista de Alumnos
        final List<Alumno> alumnos = bd.alumnoDao().getAllAlumnos();

        //Se hace la ferencia al RecyclerView de Layout activity_main
        recyclerViewAlumnos = findViewById(R.id.recycler_view_alumno);
        recyclerViewAlumnos.setLayoutManager(new LinearLayoutManager(this));
        //
        adapter = new AlumnoAdapter(alumnos);

        ((AlumnoAdapter) adapter).setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Selección: " +
                        alumnos.get(recyclerViewAlumnos.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_LONG).show();


                Intent intent = new Intent(MainActivity.this, RegistrarAlumnoActivity.class);
                intent.putExtra("Nombre", alumnos.get(recyclerViewAlumnos.getChildAdapterPosition(v)).getNombre());
                intent.putExtra("Edad", alumnos.get(recyclerViewAlumnos.getChildAdapterPosition(v)).getEdad());
                intent.putExtra("Email", alumnos.get(recyclerViewAlumnos.getChildAdapterPosition(v)).getEmail());
                intent.putExtra("Id", alumnos.get(recyclerViewAlumnos.getChildAdapterPosition(v)).getId());
                intent.putExtra("estado","update");

                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Selección: " +
                        alumnos.get(recyclerViewAlumnos.getChildAdapterPosition(v)).getId(),
                        Toast.LENGTH_LONG).show();


            }
        });

        recyclerViewAlumnos.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pasa a la siguiente Activity
                Intent intent = new Intent(MainActivity.this, RegistrarAlumnoActivity.class);
                intent.putExtra("Nombre", "");
                intent.putExtra("Edad", "");
                intent.putExtra("Email", "");
                intent.putExtra("estado","new");
                intent.putExtra("Id", "");
                startActivity(intent);
            }
        });


    }

}
