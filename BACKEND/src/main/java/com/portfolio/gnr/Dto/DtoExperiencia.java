package com.portfolio.gnr.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String lugarE;
    @NotBlank
    private String fechaE;
    @NotBlank
    private String descripcionE;
    private String urlImgE;

    //Constructor
    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE,String lugarE, String fechaE, String descripcionE, String urlImgE) {
        this.nombreE = nombreE;
        this.lugarE = lugarE;
        this.fechaE = fechaE;
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
