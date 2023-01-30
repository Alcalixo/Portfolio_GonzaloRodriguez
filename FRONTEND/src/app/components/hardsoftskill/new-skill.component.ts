import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skills } from 'src/app/model/skills';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css']
})
export class NewSkillComponent implements OnInit {
  nombreS: string;
  porcentajeS: number;
  imgS: string;

  constructor(private SkillsService : SkillService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const skill = new Skills(this.nombreS, this.porcentajeS, this.imgS);
    this.SkillsService.save(skill).subscribe(
      data => {
        alert ("Skill agregada correctamente");
        this.router.navigate(['']);
      }, err => {
        alert ("Error al agregar Skill");
        this.router.navigate(['']);
      }
    )
  }
}
