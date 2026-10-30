package com.ejemplo.portafolio.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Proyecto {

    private Integer id;

    @NotBlank(message = "{proyecto.titulo.notblank}")
    private String titulo;

    @NotBlank(message = "{proyecto.descripcion.notblank}")
    private String descripcion;

    @NotBlank(message = "{proyecto.tecnologias.notblank}")
    private String tecnologias;

    @NotNull(message = "{proyecto.enlace.notnull}")
    private String enlaceGithub;

    public Proyecto() {
    }

    public Proyecto(Integer id, String titulo, String descripcion, String tecnologias, String enlaceGithub) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tecnologias = tecnologias;
        this.enlaceGithub = enlaceGithub;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getEnlaceGithub() {
        return enlaceGithub;
    }

    public void setEnlaceGithub(String enlaceGithub) {
        this.enlaceGithub = enlaceGithub;
    }
}