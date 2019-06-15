package com.example.examenfinalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewAlumnos;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;

    ArrayList<String> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        alumnos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            alumnos.add("Tally" + i);
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
