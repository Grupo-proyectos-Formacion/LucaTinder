import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AltaUsuarioComponent } from "./components/alta-usuario/alta-usuario.component";
import { ModificarUsuarioComponent } from './components/modificar-usuario/modificar-usuario.component';

const routes: Routes = [
  {path:'Alta', component:AltaUsuarioComponent},
  {path:'Modificar', component:ModificarUsuarioComponent}   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
