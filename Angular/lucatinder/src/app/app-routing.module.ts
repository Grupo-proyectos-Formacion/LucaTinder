import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AltaUsuarioComponent } from "./components/alta-usuario/alta-usuario.component";
import { ModificarUsuarioComponent } from "./components/modificar-usuario/modificar-usuario.component";
import { LikeDislikeComponent } from './components/like-dislike/like-dislike.component';
import { ListarUsuarioComponent } from './components/listar-usuario/listar-usuario.component';
import { ListarPerfilesComponent } from './components/listar-perfiles/listar-perfiles.component';
<<<<<<< Updated upstream
import { SwipeUsuariosComponent } from './components/swipe-usuarios/swipe-usuarios.component';
=======
import { PreferenciaComponent } from './components/preferencia/preferencia.component';
import { SwipeComponent } from './components/swipe/swipe.component';
>>>>>>> Stashed changes

const routes: Routes = [
  {path:'Alta', component:AltaUsuarioComponent} ,
  {path:'Modificar',component:ModificarUsuarioComponent}, 
  {path:'verPerfil', component:ListarUsuarioComponent},
  {path:'listarPerfiles', component:ListarPerfilesComponent},
<<<<<<< Updated upstream
  {path:'swipe', component:SwipeUsuariosComponent},
=======
  {path:'Preferencia', component: PreferenciaComponent},
  {path:'swipe', component: SwipeComponent}
>>>>>>> Stashed changes
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
