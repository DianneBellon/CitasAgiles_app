package com.example.proyecto_citasagiles;

public class ListArticulos {


    private int codigo;
    private String nombre;
    private String fecha;
    private String hora;


    // Construtor

    public ListArticulos(int codigo, String nombre, String fecha, String hora) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
