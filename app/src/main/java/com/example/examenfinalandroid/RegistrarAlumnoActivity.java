package com.example.examenfinalandroid;

import android.content.Intent;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrarAlumnoActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    EditText nombre;
    EditText edad;
    EditText email;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_alumno);

        nombre = findViewById(R.id.txtNombre);
        edad = findViewById(R.id.txtEdad);
        email = findViewById(R.id.txtEmail);
        guardar = findViewById(R.id.btnGuardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Gardar en la Base de Datos


            }
        });

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
