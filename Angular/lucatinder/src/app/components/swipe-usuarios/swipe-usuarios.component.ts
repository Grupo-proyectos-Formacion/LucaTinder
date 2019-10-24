import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/models/Usuario';

@Component({
  selector: 'app-swipe-usuarios',
  templateUrl: './swipe-usuarios.component.html',
  styleUrls: ['./swipe-usuarios.component.css']
})

export class SwipeUsuariosComponent implements OnInit {
  usuarioSesion:Usuario;
  perfiles: Usuario[];
  usuario:Usuario;
  numeroPerfiles:number;
  iterador:number = 0;
  constructor(private service:UsuarioService) {
  }
  async ngOnInit() {
    this.service.getSesion().subscribe(
      (data:Usuario)=>{
        console.log("HOLA TENEMOS DATOS")
        console.log(data);
        this.usuarioSesion= data;
        this.poblarPerfiles();
      }
    )
  }

  poblarPerfiles(){
    this.service.getPerfiles(this.usuarioSesion.idUsuario).subscribe(
      data=>{
        this.perfiles = data;
        console.log(this.perfiles);
        this.numeroPerfiles = this.perfiles.length;
        this.listarUsuario();
      }
    );
  }

  listarUsuario(){
    this.usuario=this.perfiles[this.iterador];
    this.iterador++;
    this.iterador%=this.numeroPerfiles;
  }





}
