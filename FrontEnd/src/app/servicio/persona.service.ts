import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { persona } from '../modelo/Persona.Modelo';

@Injectable({
  providedIn: 'root'
})

export class PersonaService {
  link= 'http://localhost:8080/persona/';

  constructor(private http: HttpClient) { }

  public getPersona(): Observable<persona>{
    return this.http.get<persona>(this.link+ 'traer/perfil'); }
    
  }
