package com.example.proyecto_citasagiles;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class SnackBar extends AppCompatActivity {
    Button bdefault, baction, bcustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);

        bdefault = findViewById(R.id.button);
        baction = findViewById(R.id.button2);
        bcustom = findViewById(R.id.button3);

        bdefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view,"HOLA", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        baction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view,"El mensaje ha sido eliminado", Snackbar.LENGTH_LONG).setAction("Deshacer", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar = Snackbar.make(view, "El mensaje ha sido recuperado", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                });
                snackbar.show();
            }
        });

        bcustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view,"Esto está personalizado", Snackbar.LENGTH_LONG).setAction("Deshacer", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Programamos cualquier acción que queramos que ejecute

                    }
                });
                snackbar.setActionTextColor(Color.BLUE);
                snackbar.setTextColor(Color.BLUE);
                snackbar.show();
            }
        });
    }
}