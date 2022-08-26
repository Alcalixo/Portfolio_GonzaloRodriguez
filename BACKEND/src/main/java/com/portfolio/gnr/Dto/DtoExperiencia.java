package com.portfolio.gnr.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    private String urlImgE;

    //Constructor
    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String descripcionE, String urlImgE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.urlImgE = urlImgE;
    }

    //Getters && Setters
    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
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
