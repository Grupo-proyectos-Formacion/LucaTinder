import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AltaUsuarioComponent } from "./components/alta-usuario/alta-usuario.component";
import { ListarPerfiles} from "src/app/components/listar-perfiles/listar-perfiles.component";


const routes: Routes = [
  {path:'Alta', component:AltaUsuarioComponent},  
  {path:'ListarPerfiles', component: ListarPerfiles} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
