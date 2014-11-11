package com.example.horth_000.invsys.model;

/**
 * Created by meow on 11-11-14.
 */
public class Sucursal {
    private int id_sucursal;
    private String nombre_sucursal;
    private String direccion_sucursal;
    private String administrador_sucursal;


    //Constructor

    public Sucursal(int id_sucursal, String nombre_sucursal, String direccion_sucursal, String administrador_sucursal){
        this.setIdsucursal(id_sucursal);
        this.setNombresucursal(nombre_sucursal);
        this.setDireccionsucursal(direccion_sucursal);
        this.setAdministradorsucursal(administrador_sucursal);
    }

    public int getIdsucursal() {
        return id_sucursal;
    }

    public void setIdsucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombresucursal() {
        return nombre_sucursal;
    }

    public void setNombresucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public String getDireccionsucursal() {
        return direccion_sucursal;
    }


    public void setDireccionsucursal(String a) {
        this.direccion_sucursal = a;
    }

    public String getAdministradorsucursal() {
        return administrador_sucursal;
    }

    public void setAdministradorsucursal(String e) {
        this.administrador_sucursal = e;
    }
}
