package com.example.horth_000.invsys.model;

/**
 * Created by meow on 11-11-14.
 */
public class Producto {
    private int id_producto;
    private String nombre_producto;
    private int fecha_ingreso;
    private int stock;
    private String nombre_categoria;
    private String nombre_distribuidor;
    private String descripcion;
    private String imagen;

    //Constructor

    public Producto(int id_producto, String nombre_producto, int fecha_ingreso, int stock, String nombre_categoria, String nombre_distribuidor, String descripcion, String imagen){
        this.setIdproducto(id_producto);
        this.setNombreproducto(nombre_producto);
        this.setFechaingreso(fecha_ingreso);
        this.setStock(stock);
        this.setNombrecategoria(nombre_categoria);
        this.setNombreDistribuidor(nombre_distribuidor); //FOREIGN KEY!!!!!!!!!!!
        this.setDescripcion(descripcion);
        this.setImagen(imagen);
    }



    public int getIdproducto() {
        return id_producto;
    }

    public void setIdproducto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombreproducto() {
        return nombre_producto;
    }

    public void setNombreproducto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getFechaingreso() {
        return fecha_ingreso;
    }

    public int getStock() {
        return stock;
    }

    public void setFechaingreso(int a) {
        this.fecha_ingreso = a;
    }

    public void setStock(int a) {
        this.stock = a;
    }

    public String getNombrecategoria() {
        return nombre_producto;
    }

    public void setNombrecategoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getNombreDistribuidor() {
        return nombre_distribuidor;
    }

    public void setNombreDistribuidor(String e) {
        this.nombre_distribuidor = e;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String e) {
        this.descripcion = e;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String e) {
        this.imagen = e;
    }
}
