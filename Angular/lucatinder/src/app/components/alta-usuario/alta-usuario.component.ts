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
      idUsuario:null,
      nombreUsuario: ["", Validators.required],
      descripcionUsuario : "",
      edadUsuario:"",
      ciudadUsuario: "",
      sexoUsuario:Boolean,
      imagenUsuario:"",
    });
  }

  get idUsuario(){return this.form.get('idUsuario');}
  get nombreUsuario(){return this.form.get('nombreUsuario');}
  get descripcionUsuario(){return this.form.get('descripcionUsuario');}
  get edadUsuario(){return this.form.get('edadUsuario');}
  get ciudadUsuario(){return this.form.get('ciudadUsuario');}
  get sexoUsuario(){return this.form.get('sexoUsuario');}
  get imagenUsuario(){return this.form.get('imagenUsuario');}

  altaUsuario(myForm:FormGroup){
    this.user = new Usuario(
      myForm.get('nombreUsuario').value,
      myForm.get('idUsuario').value,
      myForm.get('descripcionUsuario').value,
      myForm.get('edadUsuario').value,
      myForm.get('ciudadUsuario').value,
      myForm.get('sexoUsuario').value,
      myForm.get('imagenUsuario').value
    );
    this.service.crearUsuario(this.user).subscribe(
      (data:Usuario)=>{
        console.log(data);
      }
    );
  }

}