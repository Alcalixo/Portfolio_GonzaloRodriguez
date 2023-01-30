import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Skills } from '../model/skills';

@Injectable({
  providedIn: 'root'
})
export class SkillService {
  skillsUrl= environment.URL + '/hysSkill/';

  constructor(private httpClient:HttpClient) {  }

  public lista(): Observable<Skills[]>{
    return this.httpClient.get<Skills[]>(this.skillsUrl + 'lista')
  }

  public details(id: number): Observable<Skills>{
    return this.httpClient.get<Skills>(this.skillsUrl + `details/${id}`);
  }

  public save(skills: Skills): Observable<any>{
    return this.httpClient.post<any>(this.skillsUrl + `create`, skills);
  }

  public update(id: number, skills: Skills): Observable<any>{
    return this.httpClient.put<any>(this.skillsUrl + `update/${id}`, skills);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.skillsUrl + `delete/${id}`)
  }

}
