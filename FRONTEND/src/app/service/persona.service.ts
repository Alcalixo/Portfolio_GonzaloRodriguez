import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
//import { environment } from 'src/environments/environment';
import { persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root',
})
export class PersonaService {
  URL = 'http://localhost:8080/personas';

  constructor(private httpClient: HttpClient) {}

  public getPersona(): Observable<persona> {
    return this.httpClient.get<persona>(this.URL + '/lista');
  }
}
