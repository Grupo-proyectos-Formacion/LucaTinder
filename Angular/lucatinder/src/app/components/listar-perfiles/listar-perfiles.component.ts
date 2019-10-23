import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario.service';


@Component({
  selector: 'app-listar-perfiles',
  templateUrl: './listar-perfiles.component.html',
  styleUrls: ['./listar-perfiles.component.css']
})
export class ListarPerfilesComponent implements OnInit {

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
  }

}
