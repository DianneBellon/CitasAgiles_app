package com.example.proyecto_citasagiles;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_citasagiles.persistencia.DbMedicos;

import java.util.List;

public class AdapterArticulos extends RecyclerView.Adapter<AdapterArticulos.ViewHolderArticulos>{
    List<ListArticulos> listArticulos;
    FragmentActivity context;

    public AdapterArticulos(List<ListArticulos> listArticulos, FragmentActivity context) {
        this.listArticulos = listArticulos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderArticulos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_articulos, null, false);
        return new ViewHolderArticulos(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArticulos holder, int position) {
        holder.asignarArticulos(listArticulos.get(position));
    }

    @Override
    public int getItemCount() {
        return listArticulos.size();
    }

    public class ViewHolderArticulos extends RecyclerView.ViewHolder {

        TextView nombrep;
        TextView codigop;
        TextView hora;
        TextView fecha;
        Button btnEdit;
        Button btnRemove;
        FragmentActivity context;

        public ViewHolderArticulos(@NonNull View itemView, FragmentActivity context) {
            super(itemView);
            nombrep = itemView.findViewById(R.id.nombre);
            codigop = itemView.findViewById(R.id.codigo);
            hora = itemView.findViewById(R.id.hora);
            fecha = itemView.findViewById(R.id.fecha);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnRemove = itemView.findViewById(R.id.btnRemove);
            this.context = context;
        }

        public void asignarArticulos(ListArticulos a) {
            nombrep.setText(a.getNombre().trim());
            codigop.setText(Integer.toString(a.getCodigo()).trim());
            hora.setText(a.getHora().trim());
            fecha.setText(a.getFecha().trim());
            btnEdit.setOnClickListener(view -> ((CardsItems) context).switchWindow(new ActualizarArticulo(a)));
            btnRemove.setOnClickListener(view -> {
                DbMedicos c = new DbMedicos(context);
                c.eliminarArticulo(Integer.toString(a.getCodigo()));
                Toast.makeText(context, "Se ha eliminado: " + a.getNombre(), Toast.LENGTH_SHORT).show();
                c.close();
                ((CardsItems) context).switchWindow(new VerArticulos());
            });
        }
    }
}


