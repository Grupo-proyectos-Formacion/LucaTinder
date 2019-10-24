import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AltaUsuarioComponent } from "./components/alta-usuario/alta-usuario.component";
import { ModificarUsuarioComponent } from "./components/modificar-usuario/modificar-usuario.component";
import { LikeDislikeComponent } from './components/like-dislike/like-dislike.component';
import { ListarUsuarioComponent } from './components/listar-usuario/listar-usuario.component';
import { ListarPerfilesComponent } from './components/listar-perfiles/listar-perfiles.component';
import { SwipeUsuariosComponent } from './components/swipe-usuarios/swipe-usuarios.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {path:'', component:LoginComponent},
  {path:'Alta', component:AltaUsuarioComponent} ,
  {path:'Modificar',component:ModificarUsuarioComponent}, 
  {path:'Elegir',component:LikeDislikeComponent},
  {path:'verPerfil', component:ListarUsuarioComponent},
  {path:'listarPerfiles', component:ListarPerfilesComponent},
  {path:'swipe', component:SwipeUsuariosComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
