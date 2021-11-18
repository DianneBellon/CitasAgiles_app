package com.example.proyecto_citasagiles.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=4;
    private static final String DATABASE_NOMBRE = "citasagiles.db";
    private static final String TABLE_USUARIOS = "usuarios";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_USUARIOS + "("+
                "numdoc INTEGER PRIMARY KEY," +
                "tipodoc TEXT NOT NULL,"+
                "nombres TEXT NOT NULL,"+
                "apellidos TEXT NOT NULL,"+
                "correo TEXT NOT NULL,"+
                "contraseña TEXT NOT NULL,"+
                "fecha_hora TEXT NOT NULL,"+
                "tipousuario TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(" DROP TABLE " + TABLE_USUARIOS);
        onCreate(sqLiteDatabase);

    }
}