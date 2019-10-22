import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../models/Usuario';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http:HttpClient) { 
  
  }
  private userUrl = 'http://10.90.36.105:8080/crear/usuario/rest';


  public crearUsuario(usuario) {
    return this.http.post<Usuario>(this.userUrl, Usuario);
  }
}
