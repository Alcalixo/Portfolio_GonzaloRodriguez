export class Proyectos {
    id?: number;
    nombreP: string;
    descripcionP: string;
    urlImgP: string;

    constructor( nombreP: string, descripcionP: string, urlImgP: string) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.urlImgP = urlImgP;
    }
}
