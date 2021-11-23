package com.example.proyecto_citasagiles.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=2; // Cambia/aumenta la versión cuando añadimos una tabla o una columna a nuestra base de datos
    private static final String DATABASE_NOMBRE = "scenario.db";
    public static final String TABLE_USERS = "usuarios";
    public static final String TABLE_PRODUCTOS = "productos";
    // Las tablas deben tener nombres en plural
    // Los atributos/columna dben tener nombres en singular

    // Context = donde estamos ubicados (AQUÍ)
    // Constructor DbHelper
    // onCreate
    // onStart
    // onResume

    // Corre la app

    //Constructor
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_USERS + "("+
                "idusuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomusuario TEXT NOT NULL,"+
                "contrasena TEXT NOT NULL,"+
                "correo TEXT NOT NULL)");

        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_PRODUCTOS + "("+
                "codigop INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombrep TEXT NOT NULL,"+
                "precio DECIMAL NOT NULL,"+
                "descripcion TEXT NOT NULL)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);// Consulta
        onCreate(sqLiteDatabase);

    }

}
