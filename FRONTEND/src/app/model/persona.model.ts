export class persona {
    id?: number;
    nombre: string;
    apellido: string;
    img: string;
    descripcion: string;
    profesion: string;

    constructor( nombre: string, apellido: string, img: string ,descripcion: string, profesion : string ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.descripcion = descripcion;
        this.profesion = profesion;
    }
}