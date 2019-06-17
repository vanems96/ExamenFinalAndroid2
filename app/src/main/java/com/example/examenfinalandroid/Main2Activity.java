package com.example.examenfinalandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    private ExpandableListView expandableMedidas;
    private ExpandibleAdaptador adapter;
    private ArrayList<String> listMedidas;
    private Map<String, ArrayList<String>> mapChild;


    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Prepara la Conexion a la DB
        AppDatabase bd = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "datosFechas")
                .allowMainThreadQueries()
                .build();

        final List<Fecha> fechas = bd.fechaDao().getAllFechas();
        expandableMedidas= findViewById(R.id.recycler_view_fecha);


        expandableMedidas =(ExpandableListView) findViewById(R.id.Expandible);
        listMedidas = new ArrayList<>();
        mapChild = new HashMap<>();
        cargarDatos();

        adapter = new ExpandibleAdaptador(fechas);
        expandableMedidas.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MedidasAlumnoActivity.class);
                startActivity(intent);
            }
        });

    }

    private void cargarDatos(){
        ArrayList<String> fechaMedidas = new ArrayList<>();

        listMedidas.add("Fecha: 12/56/2109");

        fechaMedidas.add("Porcentaje grasa: 12");
        fechaMedidas.add("Masa muscular: 13");
        fechaMedidas.add("Peso en kilos: 123");
        fechaMedidas.add("Edad metabolica: 12");

        mapChild.put(listMedidas.get(0),fechaMedidas);

        adapter = new ExpandibleAdaptador(listMedidas,mapChild,this);
        expandableMedidas.setAdapter(adapter);



    }
}
