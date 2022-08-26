export class Educacion {
    id?: number;
    nombreEdu: string;
    descripcionEdu: string;
    urlImgEdu: string;

    constructor(nombreEdu: string, descripcionEdu: string, urlImgEdu: string) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.urlImgEdu = urlImgEdu;
    }
}