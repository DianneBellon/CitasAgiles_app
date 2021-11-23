package com.example.proyecto_citasagiles.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbUsuarios extends DbHelper{

    Context context; // Variable global

    // CRUD
    // C = CREAR
    // R = LEER
    // U = ACTUALIZAR
    // D = ELIMINAR

    // Constructor
    public DbUsuarios(@Nullable Context context) {
        // SUPER: Llama al contructor de la clase padre
        super(context);
        this.context = context;
    }

    // Long: Es de tipo entero de mayor tamaño


    // NEW
    public Boolean insertarUsuario(String nomusuario, String contrasena){
        DbHelper dbHelper = new DbHelper(context); // Intancia del objeto DbHleper = nuestra base de datos
        SQLiteDatabase db = dbHelper.getWritableDatabase(); // Agregamos los datos

        ContentValues values = new ContentValues(); // Instancia del objeto values
        values.put("nomusuario", nomusuario);
        values.put("contrasena", contrasena);

        long result = db.insert(TABLE_USERS, null, values);
        if (result == -1)
            return false;
        else
            return true;

    }

    public Boolean checknomusuario(String nomusuario){
        DbHelper dbHelper = new DbHelper(context); // Instancia del objeto DbHelper
        SQLiteDatabase db = dbHelper.getWritableDatabase(); //
        // Colección de filas que son aleatorias
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE nomusuario =?", new String[] {nomusuario});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkcontrasena(String nomusuario, String contrasena){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE nomusuario =? and contrasena=?", new String[] {nomusuario, contrasena});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}

//        long id = 0;
//
//        try{
//            DbHelper dbHelper = new DbHelper(context); // Intancia del objeto DbHleper = nuestra base de datos
//            SQLiteDatabase db = dbHelper.getWritableDatabase(); // Agregamos los datos
//
//            ContentValues values = new ContentValues(); // Instancia del objeto values
//            values.put("nomusuario", nomusuario);
//            values.put("contrasena", contrasena);
//
//            id = db.insert(TABLE_USERS, null, values);
//
//        } catch (Exception ex){
//            ex.toString();
//        }
//
//
//        return id;


