package com.example.leon_zea;

import java.io.Serializable;

public class Producto implements Serializable {
    private  String nombre;
    private Double precio;
    private String url_img;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public Producto(){

    }

    public Producto(String nombre, Double precio, String url_img) {
        this.nombre = nombre;
        this.precio = precio;
        this.url_img = url_img;
    }
}
