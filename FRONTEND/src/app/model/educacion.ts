export class Educacion {
    id?: number;
    nombreEdu: string;
    lugarEdu: string;
    fechaEdu: string;
    descripcionEdu: string;
    urlImgEdu: string;

    constructor(nombreEdu: string, lugarEdu: string, fechaEdu: string, descripcionEdu: string, urlImgEdu: string) {
        this.nombreEdu = nombreEdu;
        this.lugarEdu = lugarEdu;
        this.fechaEdu = fechaEdu;
        this.descripcionEdu = descripcionEdu;
        this.urlImgEdu = urlImgEdu;
    }
}