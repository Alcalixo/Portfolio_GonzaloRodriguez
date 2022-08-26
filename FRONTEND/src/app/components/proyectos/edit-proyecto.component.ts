import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyectos } from 'src/app/model/proyectos';
import { ProyectosService } from 'src/app/service/proyectos.service';

@Component({
  selector: 'app-edit-proyecto',
  templateUrl: './edit-proyecto.component.html',
  styleUrls: ['./edit-proyecto.component.css']
})
export class EditProyectoComponent implements OnInit {
  proyectos: Proyectos = null;

  constructor(private sProyectos: ProyectosService, private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.sProyectos.detail(id).subscribe(data => {
      this.proyectos = data;
    }, err =>{
      alert ("Error al Modificar");
      this.router.navigate(['']);
    })
  }

  onUpdate():void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.sProyectos.update(id, this.proyectos).subscribe(data => {
      alert ("Actualizado datos del Proyecto");
      this.router.navigate(['']);
    }, err => {
      alert ("Error al Modificar");
      this.router.navigate(['']);
    }
    )}
}
