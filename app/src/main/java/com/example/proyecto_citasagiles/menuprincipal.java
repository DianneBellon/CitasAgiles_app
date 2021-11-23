package com.example.proyecto_citasagiles;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class menuprincipal extends AppCompatActivity {

    TextView singin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
        singin = findViewById(R.id.singin);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int opt = item.getItemId();
        float valor;

        switch(opt){
            case R.id.asinarcita:
                // Instanciamos nuestro objeto "cambiar"
                Intent cambiar = new Intent(menuprincipal.this, AsignacionCitasMedicas.class);
                startActivity(cambiar);
                return true;
            case R.id.infocita:
                // Instanciamos nuestro objeto "cambiar"
                Intent cambiar1 = new Intent(menuprincipal.this, InformacionCita.class);
                startActivity(cambiar1);
                return true;
            case R.id.modcita:
                // Instanciamos nuestro objeto "cambiar"
                Intent cambiar2 = new Intent(menuprincipal.this, ModificarCita.class);
                startActivity(cambiar2);
                return true;
            case R.id.cancita:
                // Instanciamos nuestro objeto "cambiar"
                Intent cambiar3 = new Intent(menuprincipal.this, CancelarCita.class);
                startActivity(cambiar3);
                return true;
            case R.id.salir:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}