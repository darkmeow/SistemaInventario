package com.example.horth_000.invsys.model;

/**
 * Created by meow on 11-11-14.
 */
public class Distribuidor {
    private int id_distribuidor;
    private String nombre_distribuidor;
    private String correo_distribuidor;
    private int telefono_distribuidor;
    private String direccion_distribuidor;

    public Distribuidor(int id_distribuidor, String nombre_distribuidor, String correo_distribuidor, int telefono_distribuidor, String direccion_distribuidor){
        this.setIddistribuidor(id_distribuidor);
        this.setNombredistribuidor(nombre_distribuidor);
        this.setCorreodistribuidor(correo_distribuidor);
        this.setTelefonodistribuidor(telefono_distribuidor);
        this.setDirecciondistribuidor(direccion_distribuidor);
    }

    public int getIddistribuidor() {
        return id_distribuidor;
    }

    public void setIddistribuidor(int id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }

    public String getNombredistribuidor() {
        return nombre_distribuidor;
    }

    public void setNombredistribuidor(String nombre_distribuidor) {
        this.nombre_distribuidor = nombre_distribuidor;
    }

    public String getCorreodistribuidor() {
        return correo_distribuidor;
    }

    public void setCorreodistribuidor(String e) {
        this.correo_distribuidor = e;
    }

    public int getTelefonodistribuidor() {
        return telefono_distribuidor;
    }

    public void setTelefonodistribuidor(int e) {
        this.telefono_distribuidor = e;
    }

    public String getDirecciondistribuidor() {
        return direccion_distribuidor;
    }


    public void setDirecciondistribuidor(String a) {
        this.direccion_distribuidor = a;
    }

}
