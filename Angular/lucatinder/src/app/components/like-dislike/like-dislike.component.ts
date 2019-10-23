import { Component, OnInit, Input } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Interaccion } from '../../models/interaccion';

@Component({
  selector: 'app-like-dislike',
  templateUrl: './like-dislike.component.html',
  styleUrls: ['./like-dislike.component.css']
})
export class LikeDislikeComponent implements OnInit {
  interaccion:Interaccion;
  resultado:boolean;
  @Input() idTronista: number;
  constructor(private service: UsuarioService) { }

  ngOnInit() {
  }

  enviarResultado(result:boolean){
    this.interaccion = new Interaccion(
      result,
      this.idTronista
    )
    this.service.postResultadoInteraccion(this.interaccion).subscribe();
  }

}
