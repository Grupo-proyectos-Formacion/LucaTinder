import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs/Subscription';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-modificar-usuario',
  templateUrl: './modificar-usuario.component.html',
  styleUrls: ['./modificar-usuario.component.css']

})
export class ModificarUsuarioComponent implements OnInit {

  usuario:any = {}; //POR QUE???
  sub:Subscription;

  constructor(private route: ActivatedRoute,
  private router: Router,
  private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];

  }

}
