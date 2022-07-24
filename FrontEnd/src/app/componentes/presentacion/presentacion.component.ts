import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/modelo/Persona.Modelo';
import { PersonaService } from 'src/app/servicio/persona.service';

@Component({
  selector: 'app-presentacion',
  templateUrl: './presentacion.component.html',
  styleUrls: ['./presentacion.component.css']
})
export class PresentacionComponent implements OnInit {

  persona: persona = new persona("","","");

  constructor(public personaServicio: PersonaService) { }

  ngOnInit(): void {
    this.personaServicio.getPersona().subscribe(dato => {this.persona = dato})
  }

}
