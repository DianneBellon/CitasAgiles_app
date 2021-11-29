package com.example.proyecto_citasagiles;


import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.proyecto_citasagiles.persistencia.DbMedicos;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrearArticulo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrearArticulo extends Fragment {


    public CrearArticulo() {
        // Required empty public constructor
    }

    public static CrearArticulo newInstance() {
        CrearArticulo fragment = new CrearArticulo();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_crear_articulo, container, false);

        TextInputEditText tfNombre = root.findViewById(R.id.tfNombre);
        TextInputEditText tfFecha = root.findViewById(R.id.tfFecha);
        TextInputEditText tfHora = root.findViewById(R.id.tfHora);
        Button btnAgregar = root.findViewById(R.id.btnAgregar);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!TextUtils.isEmpty(tfNombre.getText().toString().trim()) &&
                        !TextUtils.isEmpty(tfFecha.getText().toString().trim()) &&
                        !TextUtils.isEmpty(tfHora.getText().toString().trim())) {

                    DbMedicos db = new DbMedicos(root.getContext());
                    db.agregarArticulo(tfNombre.getText().toString().trim(), tfFecha.getText().toString().trim(), tfHora.getText().toString().trim());
                    Toast.makeText(getActivity(), "Cita Medica asignada : " + tfNombre.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                    ((CardsItems) getActivity()).switchWindow(new VerArticulos());
                    db.close();

                } else {
                    Toast.makeText(root.getContext(), "Error, hay campos sin llenar", Toast.LENGTH_SHORT).show();
                }


            }
        });

        return root;
    }
}
