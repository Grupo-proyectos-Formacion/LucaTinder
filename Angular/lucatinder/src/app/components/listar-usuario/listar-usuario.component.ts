import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/models/Usuario';
import { LikeDislikeComponent } from '../like-dislike/like-dislike.component'


@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.css']
})
export class ListarUsuarioComponent implements OnInit {

  usuario: Usuario;
  constructor(private service:UsuarioService) { 
  }

  async ngOnInit() {
    this.service.getSesion().subscribe(
      data => {
        this.usuario = data;
        console.log(data);
      },
      error => console.log(error)
    )
  }

}
