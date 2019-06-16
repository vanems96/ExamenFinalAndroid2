package com.example.examenfinalandroid;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewAlumnos;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;


    /////////////////////////////////////////////////tally///////////////////////////////////////////
    ArrayList<Alumno> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        alumnos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Alumno alumno = new Alumno("Marco" + i, 24, "marcotally@gmail.com");
            alumnos.add(alumno);
        }

        recyclerViewAlumnos = findViewById(R.id.recycler_view_alumno);
        recyclerViewAlumnos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AlumnoAdapter(alumnos);
        recyclerViewAlumnos.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pasa a la siguiente Activity
                startActivity(new Intent(MainActivity.this, RegistrarAlumnoActivity.class));
            }
        });
    }

}
