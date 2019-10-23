import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../models/Usuario';
import * as myGlobals from '../variables/globals'

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http:HttpClient) { 
  }
  
  public crearUsuario(usuario) {
    console.log(usuario);
    return this.http.post<Usuario>(myGlobals.url+"/crear/usuario/rest", usuario, httpOptions);
  }

  public getUsuario() {
    return this.http.get<Usuario>(myGlobals.url+"/get/session");
  } 

}