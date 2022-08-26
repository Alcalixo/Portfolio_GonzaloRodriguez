package com.portfolio.gnr.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyectos {

    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    private String urlImgP;

    //Constructor
    public DtoProyectos() {
    }

    public DtoProyectos(String nombreP, String descripcionP, String urlImgP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.urlImgP = urlImgP;
    }
    //Getters && Setters

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

    public void setUrlImgP(String urlImgP) {
        this.urlImgP = urlImgP;
    }

}
