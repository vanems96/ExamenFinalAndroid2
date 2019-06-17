package com.example.examenfinalandroid;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MedidasAlumnoActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String CERO = "0";
    private static final String DOS_PUNTOS = ":";
    private static final String BARRA = "/";

    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    //Fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    //Hora
    final int hora = c.get(Calendar.HOUR_OF_DAY);
    final int minuto = c.get(Calendar.MINUTE);

    //Widgets
    EditText etFecha, etHora;
    ImageButton ibObtenerFecha, ibObtenerHora;

    Button btnGuardarM;

   EditText porcentajeGrasa;
   EditText masaMuscular;
   EditText pesoEnKg;
   EditText edadMetbolica;
   EditText fechaMedidas;

    Bundle datos;

    String idSelect;



     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_medidas_alumno);

         etFecha = (EditText) findViewById(R.id.et_mostrar_fecha_picker);
         etHora = (EditText) findViewById(R.id.et_mostrar_hora_picker);

         ibObtenerFecha = (ImageButton) findViewById(R.id.ib_obtener_fecha);
         ibObtenerHora = (ImageButton) findViewById(R.id.ib_obtener_hora);

         ibObtenerFecha.setOnClickListener(this);
         ibObtenerHora.setOnClickListener(this);

         btnGuardarM = findViewById(R.id.btnGuardarM);

         porcentajeGrasa = findViewById(R.id.textInPorcentajeGrasa);
         masaMuscular = findViewById(R.id.textInMasaMuscular);
         pesoEnKg = findViewById(R.id.textInPesoKg);
         edadMetbolica = findViewById(R.id.textInEdadMetabolica);

         datos = getIntent().getExtras();

         idSelect = datos.getString("idAlumno");


         final AppDatabase bd = Room.databaseBuilder(getApplicationContext(),
                 AppDatabase.class,"datosFechas").allowMainThreadQueries()
                 .build();

         btnGuardarM.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 //TODO: Gardar en la Base de Datos

                 try {

                     bd.fechaDao().insertAll(
                             new Fecha(etFecha.getText().toString(),
                                     porcentajeGrasa.getText().toString(),
                                     masaMuscular.getText().toString(),
                                     pesoEnKg.getText().toString(),
                                     edadMetbolica.getText().toString(),idSelect));

                 } catch (Exception i){
                     Toast.makeText(getApplicationContext(),
                             "No se puede repetir la fecha!",
                             Toast.LENGTH_LONG).show();

                 }

                 startActivity(new Intent(
                         MedidasAlumnoActivity.this, MostrarHistoricosActivity.class));


                 /*bd.fechaDao().insertAll(
                         new Fecha(Integer.parseInt(etFecha.getText().toString()),
                                 Integer.parseInt(porcentajeGrasa.getText().toString()),
                                 Integer.parseInt(masaMuscular.getText().toString()),
                                 Integer.parseInt(pesoEnKg.getText().toString()),
                                 Integer.parseInt(edadMetbolica.getText().toString())));
                 startActivity(new Intent(MedidasAlumnoActivity.this, MostrarHistoricosActivity.class));*/


             }
         });

     }

    public void obtenerFecha() {
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                final int mesActual = month + 1;

                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);

                etFecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);


            }
        },anio, mes, dia);

        recogerFecha.show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_obtener_fecha:
                obtenerFecha();
                break;
            case R.id.ib_obtener_hora:
                obtenerHora();
                break;
        }
    }



    private void obtenerHora(){
        TimePickerDialog recogerHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                String horaFormateada =  (hourOfDay < 9)? String.valueOf(CERO + hourOfDay) : String.valueOf(hourOfDay);
                String minutoFormateado = (minute < 9)? String.valueOf(CERO + minute):String.valueOf(minute);

                String AM_PM;
                if(hourOfDay < 12) {
                    AM_PM = "a.m.";
                } else {
                    AM_PM = "p.m.";
                }

                etHora.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }

        }, hora, minuto, false);

        recogerHora.show();
    }

    public void RegresarHome(View view){
        Intent intent = new Intent(MedidasAlumnoActivity.this, MainActivity.class);
        startActivity(intent);
    }

   /* public void limpiarDatosFecha(){
        etFecha.setText("");
        porcentajeGrasa.setText("");
        masaMuscular.setText("");
        pesoEnKg.setText("");
        edadMetbolica.setText("");

    }*/
}
