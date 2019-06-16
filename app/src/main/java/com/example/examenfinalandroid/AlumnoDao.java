package com.example.examenfinalandroid;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AlumnoDao {

    @Query("SELECT * FROM alumno")
    List<Alumno> getAllAlumnos();

    @Insert
    void insertAll(Alumno... alumnos);
}

