import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/models/Usuario';


@Component({
  selector: 'app-listar-perfiles',
  templateUrl: './listar-perfiles.component.html',
  styleUrls: ['./listar-perfiles.component.css']
})
export class ListarUsuarioComponent implements OnInit {

  usuario: Usuario[];
  constructor(private service:UsuarioService) { 
    this.service.getSesion().subscribe(
      data => {
        this.usuario = data;
        console.log(data);
      },
      error => console.log(error)
    )
  }

  ngOnInit() {
  }

}

