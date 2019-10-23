import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/models/Usuario';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-modificar-usuario',
  templateUrl: './modificar-usuario.component.html',
  styleUrls: ['./modificar-usuario.component.css']
})
export class ModificarUsuarioComponent implements OnInit {
  usuario: Usuario;
  form:FormGroup;

  constructor(private service:UsuarioService, private fb:FormBuilder) {
    
    this.service.getSesion().subscribe(
      (data:Usuario)=>{
        console.log("HOLA TENEMOS DATOS")
        console.log(data);
        this.usuario = data;
        this.createForm();
      }
    )
    
  }

  ngOnInit() {
  }
  get idUsuario(){return this.form.get('idUsuario');}
  get nombreUsuario(){return this.form.get('nombreUsuario');}
  get descripcionUsuario(){return this.form.get('descripcionUsuario');}
  get edadUsuario(){return this.form.get('edadUsuario');}
  get ciudadUsuario(){return this.form.get('ciudadUsuario');}
  get sexoUsuario(){return this.form.get('sexoUsuario');}
  get imagenUsuario(){return this.form.get('imagenUsuario');}

 
  createForm() {
    this.form = this.fb.group({
      idUsuario:this.usuario.idUsuario,
      nombreUsuario: [this.usuario.nombreUsuario, Validators.required],
      descripcionUsuario : this.usuario.descripcionUsuario,
      edadUsuario: this.usuario.edadUsuario,
      ciudadUsuario: this.usuario.ciudadUsuario,
      sexoUsuario: this.usuario.sexoUsuario,
      imagenUsuario: this.usuario.imagenUsuario,
    });
  }
  
}
