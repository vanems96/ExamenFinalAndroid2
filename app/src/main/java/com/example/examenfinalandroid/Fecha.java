package com.example.examenfinalandroid;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Fecha {
    @PrimaryKey
    @ColumnInfo(name = "fechaMedidas")
    @NonNull
    private String fechaMed;

    @ColumnInfo(name = "porcentajeGrasa")
    private String porcentajeGra;

    @ColumnInfo(name = "porcentajeMasaMuscular")
    private String masaMuscular;

    @ColumnInfo(name = "pesoEnKg")
    private String pesoKg;

    @ColumnInfo(name = "edadMetabolica")
    private String edadMeta;

    @ColumnInfo(name = "idAlumno")
    private String idAlum;

    public Fecha(@NonNull String fechaMed, String porcentajeGra, String masaMuscular, String pesoKg, String edadMeta, String idAlum) {
        this.fechaMed = fechaMed;
        this.porcentajeGra = porcentajeGra;
        this.masaMuscular = masaMuscular;
        this.pesoKg = pesoKg;
        this.edadMeta = edadMeta;
        this.idAlum = idAlum;
    }

    public String getIdAlum() {return idAlum; }

    public void setIdAlum(String idAlum) {this.idAlum = idAlum;}

    public String getFechaMed() {
        return fechaMed;
    }

    public void setFechaMed(String fechaMed) {
        this.fechaMed = fechaMed;
    }

    public String getPorcentajeGra() {
        return porcentajeGra;
    }

    public void setPorcentajeGra(String porcentajeGra) {
        this.porcentajeGra = porcentajeGra;
    }

    public String getMasaMuscular() {
        return masaMuscular;
    }

    public void setMasaMuscular(String masaMuscular) {
        this.masaMuscular = masaMuscular;
    }

    public String getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(String pesoKg) {
        this.pesoKg = pesoKg;
    }

    public String getEdadMeta() {
        return edadMeta;
    }

    public void setEdadMeta(String edadMeta) {
        this.edadMeta = edadMeta;
    }
}
