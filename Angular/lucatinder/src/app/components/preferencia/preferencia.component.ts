import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import {  Preferencia} from "src/app/models/Preferencia";

@Component({
  selector: 'app-preferencia',
  templateUrl: './preferencia.component.html',
  styleUrls: ['./preferencia.component.css']
})
export class PreferenciaComponent implements OnInit {

  preferencias: Preferencia[];  

  constructor(private service:UsuarioService) {

      this.service.getPreferencias().subscribe()

   }

  ngOnInit() {
  }

  listarPrerenciasUsuario(){

    this.service.getPreferencias().subscribe(
      data => {
        this.preferencias=data;
      },
      error => console.log(error)
    )
  }

}
