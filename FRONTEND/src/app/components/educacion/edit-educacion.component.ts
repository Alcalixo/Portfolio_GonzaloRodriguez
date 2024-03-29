import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-edit-educacion',
  templateUrl: './edit-educacion.component.html',
  styleUrls: ['./edit-educacion.component.css']
})
export class EditEducacionComponent implements OnInit {
  educacion : Educacion = null;

  constructor(private educacionService : EducacionService, 
              private activatedRoute: ActivatedRoute, 
              private router : Router) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.educacionService.detail(id).subscribe(data => {
      this.educacion = data;
  }, err => {
    this.router.navigate(['']);
    alert("No posee Permisos para Modificar");
  }
  )}

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.educacionService.update(id, this.educacion).subscribe(data => {
      this.router.navigate(['']);
      alert("Educación Actualizada");
    }, err => {
      alert ("Error al Modificar");
      this.router.navigate(['']);
    }
    )}
}
