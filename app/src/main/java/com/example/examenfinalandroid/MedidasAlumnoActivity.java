package com.example.examenfinalandroid;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

public class MedidasAlumnoActivity extends AppCompatActivity {

    // ImageButton btnImage;
     //int year_x,mont_x,day_x;
     //static final int DIALOG_ID = 0;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_medidas_alumno);
     }

    /* public void showDialog(){
         btnImage =(ImageButton)findViewById(R.id.ib_obtener_fecha);

         btnImage.setOnClickListener(
                 new View.OnClickListener(){
                     @Override
                     public void onClick(View v) {
                         showDialog(DIALOG_ID);
                     }
                 }
         );
     }

 protected Dialog onCreateDialog(int id){
       if(id == DIALOG_ID)
           return new DatePickerDialog(this,dpickerListener, year_x,mont_x,day_x);         return null;
 }
 /*private DatePickerDialog.OnDateSetListener dpickerListener
         = new DatePickerDialog.OnDateSetListener(){
     @Override
     public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
         year_x = year;
         mont_x = month;
         day_x = dayOfMonth;
         Toast.makeText(MedidasAlumnoActivity.this,year_x + "/"+mont_x + "/" + day_x,Toast.LENGTH_LONG).show();
     }
 };
 */
    public void regresarHome(View view){
        Intent intent = new Intent(MedidasAlumnoActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
