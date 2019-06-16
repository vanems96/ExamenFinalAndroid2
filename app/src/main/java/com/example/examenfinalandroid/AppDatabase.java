package com.example.examenfinalandroid;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Alumno.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AlumnoDao alumnoDao();
}
