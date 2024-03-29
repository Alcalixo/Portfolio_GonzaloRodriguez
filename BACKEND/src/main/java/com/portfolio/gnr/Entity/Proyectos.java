package com.portfolio.gnr.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private String descripcionP;
    private String urlImgP;

    //Constructor
    public Proyectos() {
    }

    public Proyectos(String nombreP, String descripcionP, String urlImgP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.urlImgP = urlImgP;
    }
    //Getters && Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getUrlImgP() {
        return urlImgP;
    }

    public void setUrlImg(String urlImgP) {
        this.urlImgP = urlImgP;
    }

}
