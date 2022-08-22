import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Educacion } from '../model/educacion';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {
  educacionURL = 'https://frozen-ravine-99958.herokuapp.com/educacion/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Educacion[]>{
    return this.httpClient.get<Educacion[]>(this.educacionURL + 'lista');
  }

  public detail(id: number): Observable<Educacion>{
    return this.httpClient.get<Educacion>(this.educacionURL + `detail/${id}`);
  }

  public save(educacion : Educacion): Observable<any>{
    return this.httpClient.post<any>(this.educacionURL + 'create', educacion)
  }

  public update(id : number, educacion : Educacion): Observable<any>{
    return this.httpClient.put<any>(this.educacionURL + `update/${id}`, educacion)
  }

  public delete(id : number): Observable<any>{
    return this.httpClient.delete<any>(this.educacionURL + `delete/${id}`)
  }
}
