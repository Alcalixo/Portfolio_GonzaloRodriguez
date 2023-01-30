import { Component, OnInit } from '@angular/core';
import { Skills } from 'src/app/model/skills';
import { SkillService } from 'src/app/service/skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-hardsoftskill',
  templateUrl: './hardsoftskill.component.html',
  styleUrls: ['./hardsoftskill.component.css']
})
export class HardsoftskillComponent implements OnInit {
  skill: Skills[] = [];
  
  constructor(private sSkill: SkillService, private tokenService : TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarSkills();
    if (this.tokenService.getToken()){
      this.isLogged=true;
    } else {
      this.isLogged=false;
    }
  }

  cargarSkills(): void {
    this.sSkill.lista().subscribe (
      data => {
        this.skill = data;
      } 
    )
  }

  delete(id: number){
    if (id != undefined){
      this.sSkill.delete(id).subscribe(
        data =>{
          this.cargarSkills();
        }, err => {
          alert ("Error al borrar Skill");
        }
      )
    }
  } 

}
