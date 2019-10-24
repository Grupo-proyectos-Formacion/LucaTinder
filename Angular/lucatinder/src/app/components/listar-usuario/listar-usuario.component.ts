import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/models/Usuario';
import { LikeDislikeComponent } from '../like-dislike/like-dislike.component'
import { Preferencia } from 'src/app/models/preferencia';


@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.css']
})
export class ListarUsuarioComponent implements OnInit {

  usuario: Usuario;
  preferencias: Preferencia[];
  constructor(private service:UsuarioService) { 
  }

  async ngOnInit() {
    this.service.getSesion().subscribe(
      (data:Usuario) => {
        this.usuario = data;
        console.log(data);
        this.poblarPreferencias();
      },
      error => console.log(error)
    )

  }

  poblarPreferencias(){
    this.service.getPreferencias().subscribe(
      (data:Preferencia[])=>{
        this.preferencias =data;
      }
    )
  }
}
