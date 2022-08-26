export class Experiencia {
    id?: number;
    nombreE: string;
    descripcionE: string;
    urlImgE: string;

    constructor(nombreE: string, descripcionE: string, urlImgE: string) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.urlImgE = urlImgE;
    }
}
