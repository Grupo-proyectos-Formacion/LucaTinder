import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/Usuario';
import { UsuarioService } from 'src/app/services/usuario.service';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  usuario:string;
  form: any;


  constructor(private service:UsuarioService,  private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,) { }

  ngOnInit() {
   
  }
  createF.
  get nombreUsuario(){return this.form.get('nombreUsuario');}
  logIn(){
    if(this.usuario == ){
      this.router.navigate(["user"]);
     }else {
       alert("Invalid credentials");
  }
}
