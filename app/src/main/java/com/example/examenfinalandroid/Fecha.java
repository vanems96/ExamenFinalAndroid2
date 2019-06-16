package com.example.examenfinalandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Fecha {
    @PrimaryKey(autoGenerate = true)
    private int numFecha;

    @ColumnInfo(name = "fechaMedidas")
    private int fechaMed;

    @ColumnInfo(name = "porcentajeGrasa")
    private int porcentajeGra;

    @ColumnInfo(name = "porcentajeMasaMuscular")
    private int masaMuscular;

    @ColumnInfo(name = "pesoEnKg")
    private int pesoKg;

    @ColumnInfo(name = "edadMetabolica")
    private int edadMeta;

    public Fecha(int fechaMed, int porcentajeGra, int masaMuscular, int pesoKg, int edadMeta) {
        this.fechaMed = fechaMed;
        this.porcentajeGra = porcentajeGra;
        this.masaMuscular = masaMuscular;
        this.pesoKg = pesoKg;
        this.edadMeta = edadMeta;
    }

    public int getFechaMed() { return fechaMed; }

    public void setFechaMed(int fechaMed) { this.fechaMed = fechaMed; }

    public int getNumFecha() { return numFecha; }

    public void setNumFecha(int numFecha) { this.numFecha = numFecha; }

    public int getPorcentajeGra() { return porcentajeGra; }

    public void setPorcentajeGra(int porcentajeGra) { this.porcentajeGra = porcentajeGra; }

    public int getMasaMuscular() { return masaMuscular; }

    public void setMasaMuscular(int masaMuscular) { this.masaMuscular = masaMuscular; }

    public int getPesoKg() { return pesoKg; }

    public void setPesoKg(int pesoKg) { this.pesoKg = pesoKg; }

    public int getEdadMeta() { return edadMeta; }

    public void setEdadMeta(int edadMeta) { this.edadMeta = edadMeta; }
}
