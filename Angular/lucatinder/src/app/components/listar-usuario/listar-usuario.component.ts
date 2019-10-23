import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as myGlobals from 'src/app/variables/globals'
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/models/Usuario';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
 };
@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.css']
})
export class ListarUsuarioComponent implements OnInit {

  usuario: Usuario;
  constructor(private http:HttpClient, private service:UsuarioService) { 
    this.service.getUsuario().subscribe(
      data => {
        this.usuario = data;
      },
      error => console.log(error)
    )
  }

  ngOnInit() {
  }

  

}
