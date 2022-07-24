import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HmComponent } from './componentes/hm/hm.component';
import { LoguearseComponent } from './componentes/loguearse/loguearse.component';

const routes: Routes = [
  {path:'', component: HmComponent},
  {path:'login', component: LoguearseComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
