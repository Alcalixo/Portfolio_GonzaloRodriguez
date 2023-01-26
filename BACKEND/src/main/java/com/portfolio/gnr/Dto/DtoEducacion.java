package com.portfolio.gnr.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {

    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String lugarEdu;
    @NotBlank
    private String fechaEdu;
    @NotBlank
    private String descripcionEdu;
    private String urlImgEdu;

    //Constructor
    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEdu, String lugarEdu, String fechaEdu, String descripcionEdu, String urlImgEdu) {
        this.nombreEdu = nombreEdu;
        this.lugarEdu = lugarEdu;
        this.fechaEdu = fechaEdu;
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

    public String getLugarEdu() {
        return lugarEdu;
    }

    public void setLugarEdu(String lugarEdu) {
        this.lugarEdu = lugarEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
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
