package com.example.proyecto_citasagiles;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Productos extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        init();

    }
    public void init(){
        elements = new ArrayList<>(); // Instancia del objeto elements
        elements.add(new ListElement("#00C4CC", "Asignar nueva cita", "Colombia", "Activo")); // Tarjeta 1
        elements.add(new ListElement("#037682", "Información de cita asignada", "Colombia", "Activo")); // Tarjeta 2
        elements.add(new ListElement("#00C4CC", "Modificar cita asignada", "Colombia", "Activo")); // Tarjeta 3
        elements.add(new ListElement("#037682", "Cancelar cita asignada", "Colombia", "Activo")); // Tarjeta 4

        // Declaramos el ListAdapter y recibe una lista y el context = de donde viene
        ListAdapter listAdapter = new ListAdapter(elements, this);
        // Declaramos el RecyclerView
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        // Movemos unos parametros en verdadero
        recyclerView.setHasFixedSize(true);
        // Listado lineal setLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(listAdapter);

    }

}