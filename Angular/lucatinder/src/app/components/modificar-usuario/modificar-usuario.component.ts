import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/models/usuario';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-modificar-usuario',
  templateUrl: './modificar-usuario.component.html',
  styleUrls: ['./modificar-usuario.component.css']
})
export class ModificarUsuarioComponent implements OnInit {
  user: Usuario;
  form:FormGroup;

  constructor(private service:UsuarioService, private fb:FormBuilder) {
    
    
    
  }

  async ngOnInit() {
    this.service.getSesion().subscribe(
      (data:Usuario)=>{
        console.log("HOLA TENEMOS DATOS")
        console.log(data);
        this.user = data;
        this.createForm();
      }
    )
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
      idUsuario:this.user.idUsuario,
      nombreUsuario: [this.user.nombreUsuario, Validators.required],
      descripcionUsuario : this.user.descripcionUsuario,
      edadUsuario: this.user.edadUsuario,
      ciudadUsuario: this.user.ciudadUsuario,
      sexoUsuario: this.user.sexoUsuario,
      imagenUsuario: this.user.imagenUsuario,
    });
  }

  modificarUsuario(myForm:FormGroup){
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

  eliminarUsuario(){
    console.log("ELIMINANDO USUARIO");
    this.service.deleteUsuario(this.user.idUsuario).subscribe();
  }
  
}
