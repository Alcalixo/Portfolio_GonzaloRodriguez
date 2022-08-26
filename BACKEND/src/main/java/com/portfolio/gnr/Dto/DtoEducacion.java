package com.portfolio.gnr.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {

    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String descripcionEdu;
    private String urlImgEdu;

    //Constructor
    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEdu, String descripcionEdu, String urlImgEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.urlImgEdu = urlImgEdu;
    }

    //Getters && Setters
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
