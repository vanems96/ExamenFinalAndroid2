package com.example.examenfinalandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MedidasAlumnoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medidas_alumno);
    }

    public void regresarHistoricos(View view){
        Intent intent = new Intent(MedidasAlumnoActivity.this, MostrarHistoricosActivity.class);
        startActivity(intent);
    }
}
