package com.example.examenfinalandroid;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MostrarHistoricosActivity extends AppCompatActivity {
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    RecyclerView recyclerViewFechas;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;
    FloatingActionButton fab2;

    //TextView lblIdAlumno;

    Bundle datos;

    String idSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_historicos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        datos = getIntent().getExtras();

        idSelect = datos.getString("idAlumno");

        //lblIdAlumno = findViewById(R.id.lblIdAlumno);

        //lblIdAlumno.setText(idSelect);

        //Prepara la Conexion a la DB
        AppDatabase bd = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "datosFechas")
                .allowMainThreadQueries()
                .build();

        final List<Fecha> fechas = bd.fechaDao().getAlumnosById(idSelect);

        recyclerViewFechas= findViewById(R.id.recycler_view_fecha);
        recyclerViewFechas.setLayoutManager(new LinearLayoutManager(this));

        adapter = new FechaAdapter(fechas);
        recyclerViewFechas.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MostrarHistoricosActivity.this, MedidasAlumnoActivity.class);
                intent.putExtra("idAlumno",idSelect);
                startActivity(intent);
            }
        });


        fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MostrarHistoricosActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void RegresarHome(View view) {
        Intent intent = new Intent(MostrarHistoricosActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
