package com.example.proyecto_citasagiles;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_citasagiles.persistencia.DbMedicos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class VerArticulos extends Fragment {

    List<ListArticulos> listArticulos;
    RecyclerView recycler;

    public VerArticulos() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_ver_articulo, container, false);

        FloatingActionButton btnCrear = root.findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(view -> ((CardsItems) getActivity()).switchWindow(new CrearArticulo()));

        DbMedicos db = new DbMedicos(root.getContext());
        listArticulos = db.consultarArticulos();

        recycler = root.findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        AdapterArticulos adaptador = new AdapterArticulos(listArticulos, getActivity());
        recycler.setAdapter(adaptador);

        FloatingActionButton btnSalir = root.findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(view -> {
            ((CardsItems) getActivity()).finish();
            System.exit(0);
        });

//        SearchView vBuscar = root.findViewById(R.id.vBuscar);
//        vBuscar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                if (TextUtils.isEmpty(s)) {
//                    recycler.setAdapter(new AdapterArticulos(listArticulos, getActivity()));
//                } else {
//                    ArrayList<ListArticulos> lista2 = new ArrayList<ListArticulos>();
//                    listArticulos.stream().filter(listArticulos -> listArticulos.getDescripcion().startsWith(s) || Integer.toString(listArticulos.getCodigo()).startsWith(s) ).forEach(listArticulos -> lista2.add(listArticulos));
//                    recycler.setAdapter(new AdapterArticulos(lista2, getActivity()));
//                }
//                return false;
//            }
//        });

        return root;
    }
}
