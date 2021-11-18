package com.example.proyecto_citasagiles;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    // ViewHolder = Describe una vista de un elemento(CARD)y matadatos sobre su lugar dentro de RecyclerView
    private List<ListElement> mData;
    private LayoutInflater mInflater; // Inflater = Describe de que archivo proviene o que tipo de dato es
    private Context context; // Context Nos indica de que clase estamos llamando al Adapter

    // Contructor
    public ListAdapter(List<ListElement> itemList, Context context){
        this.mData = itemList;
        // LayoutInflater = Se usa para crear instancias del contenido de los archivos XML
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getItemCount(){

        return mData.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    // final = Tiene varios contextos:
    // 1. Modificador de no acceso aplicable a una variable, a un método o una clase
    // EX. No se pueden reasignar y debemos inicializarla
    // 2. Es una referencia de un objeto
    // Según la documentación es una buena práctica representar las variables finales en mayúsculas.
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int POSITION){
        holder.bindData(mData.get(POSITION));
    }

    public void setItems(List<ListElement> items){

        mData = items;
    }
    // ViewHolder = Describe una vista de un elemento(CARD)y matadatos sobre su lugar dentro de RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name, country, status;

        // Metodo
        ViewHolder(View itemView){
            super(itemView); // Super = Se refiere a una variable local en un método.
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.nameTextView);
            country = itemView.findViewById(R.id.countryView);
            status = itemView.findViewById(R.id.statusTextView);
        }

        void bindData(final ListElement item){
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            // PorterDuff =  Describe la forma de combinar imagenes.
            // Crearon un articulo seminal sobre "Composición imágenes"
            name.setText(item.getName());// Cambiamos el nombre
            country.setText(item.getCountry());
            status.setText(item.getStatus());
        }
    }
}



