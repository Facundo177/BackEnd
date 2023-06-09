package com.facundogaitansegura.Portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    
    private String img;
    private String link;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombre, String descripcion, String img, String link) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    
    
}