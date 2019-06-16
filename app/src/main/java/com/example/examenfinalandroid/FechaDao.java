package com.example.examenfinalandroid;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FechaDao {
    @Query("SELECT * FROM fecha")
    List<Fecha> getAllFechas();

    @Insert
    void insertAll(Fecha... fechas);
}
