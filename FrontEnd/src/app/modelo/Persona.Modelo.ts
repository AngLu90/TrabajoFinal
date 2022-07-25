export class persona{
    id?: number;
    nombre: String;
    apellido: String;
    descr: String;
    acerca: String;
    img: String


constructor(nombre: string, apellido: string, descr: String, acerca: String, img: string){
    this.nombre = nombre;
    this.apellido = apellido;
    this.descr= descr;
    this.acerca= acerca;
    this.img = img;
}
}