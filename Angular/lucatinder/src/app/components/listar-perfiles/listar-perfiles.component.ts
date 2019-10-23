import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/models/Usuario';

@Component({
  selector: 'app-listar-perfiles',
  templateUrl: './listar-perfiles.component.html',
  styleUrls: ['./listar-perfiles.component.css']
})
export class ListarPerfilesComponent implements OnInit {

  usuarios: Usuario[];
  constructor(private service:UsuarioService) { 

    this.service.getPerfiles(115).subscribe(
      data => {
        this.usuarios = data;
        console.log(data);
      },
      error => console.log(error)
    )

  }

  ngOnInit() {
  }

}
