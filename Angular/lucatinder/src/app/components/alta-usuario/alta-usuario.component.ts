import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UsuarioService } from '../../services/usuario.service'
import { Usuario } from '../../models/usuario'

@Component({
  selector: 'app-alta-usuario',
  templateUrl: './alta-usuario.component.html',
  styleUrls: ['./alta-usuario.component.css']
})
export class AltaUsuarioComponent implements OnInit {
  form:FormGroup;
  user:Usuario;
  constructor(private service:UsuarioService, private fb:FormBuilder) {
    this.createForm();
   }
  ngOnInit() {
   // this.form = this.fb.group(this.user)
   
  }

  createForm() {
    this.form = this.fb.group({
      //name: ['', Validators.required],
      nombreUsuario: ['', Validators.required],
      descripcionUsuario : "",
      edadUsuario: "",
      ciudadUsuario: "",
      imagenUsuario: "",
    });
  }

  /*altaUsuario(){
    this.service.crearUsuario(this.user);
  }*/

}