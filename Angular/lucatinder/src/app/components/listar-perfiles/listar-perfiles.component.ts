import { Component, OnInit, Input } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/models/Usuario';

@Component({
  selector: 'app-listar-perfiles',
  templateUrl: './listar-perfiles.component.html',
  styleUrls: ['./listar-perfiles.component.css']
})
export class ListarPerfilesComponent implements OnInit {
  idUsuarioActual:number;
  usuarios: Usuario[];
  constructor(private service:UsuarioService) { 
    this.service.getSesion().subscribe(
      data => {
        this.idUsuarioActual = data.idUsuario;
        console.log(data);

        /*****************************************/
        this.poblarPosiblesMatches();
      }
    )
  }

  async ngOnInit() {
    console.log(this.idUsuarioActual);
  }

  poblarPosiblesMatches(){
    this.service.getMatches().subscribe(
      data => {
        this.usuarios = data;
        console.log(data);
      },
      error => console.log(error)
    )
  }

}
