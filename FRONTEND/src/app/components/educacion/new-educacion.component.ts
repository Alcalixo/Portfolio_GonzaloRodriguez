import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-new-educacion',
  templateUrl: './new-educacion.component.html',
  styleUrls: ['./new-educacion.component.css']
})
export class NewEducacionComponent implements OnInit {
  nombreEdu: string;
  lugarEdu: string;
  fechaEdu: string;
  descripcionEdu: string;
  urlImgEdu: string;

  constructor(private educacionService: EducacionService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const edu = new Educacion(this.nombreEdu, this.lugarEdu, this.fechaEdu, this.descripcionEdu, this.urlImgEdu);
    this.educacionService.save(edu).subscribe(data => {
      alert("Educación añadida");
      this.router.navigate(['']);
    }, err => {
      alert("Falló");
    this.router.navigate(['']);
    })
}
}
