package com.portfolio.gnr.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String lugarE;
    private String fechaE;
    private String descripcionE;
    private String urlImgE;

    //Constructor
    public Experiencia() {
    }

    public Experiencia(String nombreE, String lugarE, String fechaE, String descripcionE, String urlImgE) {
        this.nombreE = nombreE;
        this.lugarE = lugarE;
        this.fechaE = fechaE;
        this.descripcionE = descripcionE;
        this.urlImgE = urlImgE;
    }
    
    //Getters && Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getLugarE() {
        return lugarE;
    }

    public void setLugarE(String lugarE) {
        this.lugarE = lugarE;
    }

    public String getFechaE() {
        return fechaE;
    }

    public void setFechaE(String fechaE) {
        this.fechaE = fechaE;
    }
    
    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getUrlImgE() {
        return urlImgE;
    }

    public void setUrlImgE(String urlImgE) {
        this.urlImgE = urlImgE;
    }

}
