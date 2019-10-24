import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { FormularioLogin } from '../../models/formulario-login';
import { Usuario } from '../../models/Usuario';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  usuario:string;
  formLog:FormularioLogin;
  mensaje:string;
  constructor(
    private service:UsuarioService,
    private router: Router,) { }

  ngOnInit() {
  }

  logIn(){
    this.formLog = new  FormularioLogin(
      this.usuario
    );
    this.service.logIn(this.formLog).subscribe(
      (data:Usuario)=>{
        console.log(data);
        if(data.nombreUsuario == this.usuario){
          this.router.navigate(['/verPerfil']);
          
        } else {
          this.mensaje = "No existe tu cuenta o no la encontramos, de cualquier modo no puedes entrar";
        }
      }
    );
    
  }

}
