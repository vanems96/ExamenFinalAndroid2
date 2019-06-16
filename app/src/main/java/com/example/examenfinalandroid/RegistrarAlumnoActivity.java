package com.example.examenfinalandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegistrarAlumnoActivity extends AppCompatActivity {

    private ImageView imageView;
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    EditText nombre;
    EditText edad;
    EditText email;
    Button guardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_alumno);
        imageView = findViewById(R.id.imageView);

        nombre = findViewById(R.id.txtNombre);
        edad = findViewById(R.id.txtEdad);
        email = findViewById(R.id.txtEmail);
        guardar = findViewById(R.id.btnGuardar);

        final AppDatabase bd = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"datosAlumnos")
                .allowMainThreadQueries()
                .build();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Gardar en la Base de Datos
                bd.alumnoDao().insertAll(new Alumno("Marco Tally",1,"w"));
                startActivity(new Intent(RegistrarAlumnoActivity.this, MainActivity.class));

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

}
