package com.portfolio.gnr.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEdu;
    private String descripcionEdu;
    private String urlImgEdu;

    //Constructor
    public Educacion() {
    }

    public Educacion(String nombreEdu, String descripcionEdu, String urlImgEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.urlImgEdu = urlImgEdu;
    }
    //Getters && Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getUrlImgEdu() {
        return urlImgEdu;
    }

    public void setUrlImgEdu(String urlImgEdu) {
        this.urlImgEdu = urlImgEdu;
    }

}
