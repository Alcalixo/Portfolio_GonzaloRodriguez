import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { ExperienciaService } from 'src/app/service/experiencia.service';

@Component({
  selector: 'app-edit-experiencia',
  templateUrl: './edit-experiencia.component.html',
  styleUrls: ['./edit-experiencia.component.css']
})
export class EditExperienciaComponent implements OnInit {
  expLab : Experiencia = null;

  constructor(private experienciaService: ExperienciaService, private activatedRoute: ActivatedRoute, private router: Router){ }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.experienciaService.detail(id).subscribe(data => {
      this.expLab = data;
    }, err => {
      alert ("No posee Permisos para Modificar");
      this.router.navigate(['']);
    }
    )}

  onUpdate():void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.experienciaService.update(id, this.expLab).subscribe(data => {
      this.router.navigate(['']);
      alert("Experiencia Actualizada");
    }, err => {
      alert ("Error al Modificar");
      this.router.navigate(['']);
    }
    )}
}
