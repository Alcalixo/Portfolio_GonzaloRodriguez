import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditEducacionComponent } from './components/educacion/edit-educacion.component';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditProyectoComponent } from './components/proyectos/edit-proyecto.component';
import { NewProyectoComponent } from './components/proyectos/new-proyecto.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'nuevaExperiencia', component: NewExperienciaComponent},
  {path: 'editarExperiencia/:id', component: EditExperienciaComponent},
  {path: 'editarEducacion/:id', component: EditEducacionComponent},
  {path: 'nuevaEducacion', component: NewEducacionComponent},
  {path: 'nuevoProyecto', component: NewProyectoComponent},
  {path: 'editarProyecto/:id', component: EditProyectoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
