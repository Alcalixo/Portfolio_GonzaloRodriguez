package com.portfolio.gnr.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {

    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String descripcionEdu;

    //Constructor
    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEdu, String descripcionEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
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

}
