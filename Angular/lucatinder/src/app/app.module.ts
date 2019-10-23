import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AltaUsuarioComponent } from './components/alta-usuario/alta-usuario.component';
import { ModificarUsuarioComponent } from './components/modificar-usuario/modificar-usuario.component';
import { LikeDislikeComponent } from './components/like-dislike/like-dislike.component';

import { ListarUsuarioComponent } from './components/listar-usuario/listar-usuario.component';
import {UsuarioService} from './services/usuario.service';
@NgModule({
  declarations: [
    AppComponent,
    AltaUsuarioComponent,
    ModificarUsuarioComponent,
    LikeDislikeComponent,
    ListarUsuarioComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
