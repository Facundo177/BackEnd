package com.facundogaitansegura.Portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoBanner {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    private String img;

    public dtoBanner() {
    }

    public dtoBanner(String nombre, String descripcion, String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}


