import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/models/Usuario';

@Component({
  selector: 'app-swipe',
  templateUrl: './swipe.component.html',
  styleUrls: ['./swipe.component.css']
})
export class SwipeComponent implements OnInit {
  usuarioSesion:Usuario;
  matches: Usuario[];
  usuario:Usuario;
  iterador:number = 0;
  constructor(private service:UsuarioService) { }

  async ngOnInit() {
    this.service.getSesion().subscribe(
      (data:Usuario)=>{
        console.log("HOLA TENEMOS DATOS")
        console.log(data);
        this.usuarioSesion= data;
        this.poblarMatches();
      }
    )
  }

  poblarMatches(){
    this.service.getPerfiles(this.usuarioSesion.idUsuario).subscribe(
      data=>{
        this.matches = data;
        console.log(this.matches);
        this.listarUsuarioActual();
      }
    );
  }

  listarUsuarioActual(){
    this.usuario = this.matches[0];
    this.iterador++;
    this.iterador%= this.matches.length;
  }

}
