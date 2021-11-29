package com.example.proyecto_citasagiles;

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

public class ActualizarArticulo extends Fragment {

    ListArticulos a;

    public ActualizarArticulo(){
        // Constructor vacio
    }

    public ActualizarArticulo(ListArticulos a){
        this.a = a;

    }

    public static ActualizarArticulo newInstance(){
        ActualizarArticulo fragment = new ActualizarArticulo(); // Instancia del objeto fragment que es de tipo ActualizarArticulo
        Bundle args = new Bundle(); // Es un formato de publicación que incluye los recursos y el código combinado de nuestras app. (APK)
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle saveInstanceStage){

        super.onCreate(saveInstanceStage);
    }
    // Inflater = Se utilizan para instanciar un archivo XML
    // Bundle saveInstanceStage = Sirve para no perder información previa, en un principio, guarda un valor null

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceStage){

        View root = inflater.inflate(R.layout.fragment_actualizar_articulo, container, false);


        TextInputEditText tfNombre = root.findViewById(R.id.tfNombre);
        TextInputEditText tfFecha = root.findViewById(R.id.tfFecha);
        TextInputEditText tfHora = root.findViewById(R.id.tfHora);
        Button btnActualizar = root.findViewById(R.id.btnActualizar);


        tfNombre.setText(a.getNombre());
        tfNombre.setEnabled(false); // Nos permite realizar el proceso de habilitación o no de un componente
        tfHora.setText(a.getHora());
        tfFecha.setText(a.getFecha());

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!TextUtils.isEmpty(tfNombre.getText().toString().trim()) &&
                        !TextUtils.isEmpty(tfHora.getText().toString().trim()) &&
                        !TextUtils.isEmpty(tfFecha.getText().toString().trim())) {

                    DbMedicos db = new DbMedicos(root.getContext());
                    db.actualizarArticulo(Integer.toString(a.getCodigo()).trim(), tfHora.getText().toString().trim(), tfFecha.getText().toString().trim());
                    Toast.makeText(getActivity(),"Actualizado: "+a.getNombre(),Toast.LENGTH_SHORT).show();
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






