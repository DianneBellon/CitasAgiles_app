package com.example.proyecto_citasagiles.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import androidx.annotation.Nullable;

import com.example.proyecto_citasagiles.ListArticulos;

import java.util.ArrayList;
import java.util.List;

public class DbMedicos extends DbHelper{

    Context context; // Variable global

    // Constructor
    public DbMedicos(@Nullable Context context){
        super(context);
        this.context = context;

    }

    public void agregarArticulo(String nombrem, String fecha, String hora) {
        ContentValues cv = new ContentValues(); // Instancia del objeto ContentValues
        cv.put("nombrem", nombrem);
        cv.put("fecha", fecha);
        cv.put("hora", hora);
        this.getWritableDatabase().insert("fecha", null, cv);
    }

    public void eliminarArticulo(String codigop) {
        this.getWritableDatabase().delete("medicos", "codigop = ?", new String[]{codigop.trim()});
    }

    public void actualizarArticulo(String codigop, String fecha, String hora) {
        ContentValues cv = new ContentValues(); // Instancia
        cv.put("fecha", fecha);
        cv.put("hora", hora);
        // trim = Es un método que se encarga de eliminar caracteres blancos iniciales y finales de una cadena de texto (String)
        this.getWritableDatabase().update("medicos", cv, "codigop = ?", new String[]{codigop.trim()});
    }

    public List<ListArticulos> consultarArticulos() {
        List<ListArticulos> listArticulos = new ArrayList<ListArticulos>(); // Instancia de un objeto tipo lista

        Cursor result = this.getWritableDatabase().query("medicos", new String[]{"codigop", "nombrem", "fecha", "hora"}, null, null, null, null, null);
        while (result.moveToNext()) {
            ListArticulos nuevoArticulo = new ListArticulos(
                    result.getInt((int) result.getColumnIndex("codigop")),
                    result.getString((int) result.getColumnIndex("nombrem")),
                    result.getString((int) result.getColumnIndex("fecha")),
                    result.getString((int) result.getColumnIndex("hora"))
            );
            listArticulos.add(nuevoArticulo);
        }

        return listArticulos;
    }


}
