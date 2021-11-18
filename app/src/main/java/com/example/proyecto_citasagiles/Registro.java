package com.example.proyecto_citasagiles;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_citasagiles.persistencia.DbHelper;

public class Registro extends AppCompatActivity {

    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistro = findViewById(R.id.btnRegistro);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(Registro.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase(); //Crearla = Escribir
                // Validación
                if(db != null){
                    Toast.makeText(Registro.this, "BASE DE DATOS CREADA",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(Registro.this,"ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}