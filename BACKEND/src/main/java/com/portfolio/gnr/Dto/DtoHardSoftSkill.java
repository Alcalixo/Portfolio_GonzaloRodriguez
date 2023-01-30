package com.portfolio.gnr.Dto;

import javax.validation.constraints.NotBlank;

public class DtoHardSoftSkill {

    @NotBlank
    private String nombreS;
    @NotBlank
    private int porcentajeS;
    private String imgS;

    //Constructor
    public DtoHardSoftSkill() {
    }

    public DtoHardSoftSkill(String nombreS, int porcentajeS, String imgS) {
        this.nombreS = nombreS;
        this.porcentajeS = porcentajeS;
        this.imgS = imgS;
    }

    //Getters & Setters
    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getPorcentajeS() {
        return porcentajeS;
    }

    public void setPorcentajeS(int porcentajeS) {
        this.porcentajeS = porcentajeS;
    }

    public String getImgS() {
        return imgS;
    }

    public void setImgS(String imgS) {
        this.imgS = imgS;
    }

}
