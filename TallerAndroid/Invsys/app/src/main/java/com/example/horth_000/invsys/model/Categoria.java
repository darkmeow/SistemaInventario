package com.example.horth_000.invsys.model;

/**
 * Created by meow on 11-11-14.
 */
public class Categoria {
    private int id_categoria;
    private String nombre_categoria;

    public Categoria(int id_categoria, String categoria){
        this.setIdcategoria(id_categoria);
        this.setNombrecategoria(nombre_categoria);
    }

    public int getIdcategoria() {
        return id_categoria;
    }

    public void setIdcategoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombrecategoria() {
        return nombre_categoria;
    }

    public void setNombrecategoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

}
