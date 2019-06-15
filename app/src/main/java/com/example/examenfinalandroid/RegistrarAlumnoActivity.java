package com.example.examenfinalandroid;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegistrarAlumnoActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_alumno);
    }

    public void RegresarHome(View view){
        Intent intent = new Intent(RegistrarAlumnoActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void irHistorico(View view){
        Intent intent = new Intent(RegistrarAlumnoActivity.this, MostrarHistoricosActivity.class);
        startActivity(intent);
    }


    public void tomarFoto(View view) {
        Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(imageTakeIntent.resolveActivity(getPackageManager()) !=null) {
            startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

}
