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

  public API = 'http://10.90.36.105:8080';
  public USUARIO_API = this.API + '/crear/usuario/rest'

  constructor(private http:HttpClient) {}

  // OBTENER
  // Método JPA Repository: Método  getOne(ID id)
  get(id: string) {
    return this.http.get(this.USUARIO_API + '/' + id);
  }

  

}
