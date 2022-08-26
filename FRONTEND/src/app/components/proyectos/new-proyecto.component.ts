import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyectos } from 'src/app/model/proyectos';
import { ProyectosService } from 'src/app/service/proyectos.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewProyectoComponent implements OnInit {
  nombreP: string;
  descripcionP: string;
  urlImgP: string;

  constructor(private sProyectos: ProyectosService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const proyectos = new Proyectos (this.nombreP, this.descripcionP, this.urlImgP);
    this.sProyectos.save(proyectos).subscribe(data =>{
      alert("Proyecto agregado");
      this.router.navigate(['']);
    }, err => {
      alert ("No se pudo agregar Proyecto");
      this.router.navigate(['']);
    })
  }
}
