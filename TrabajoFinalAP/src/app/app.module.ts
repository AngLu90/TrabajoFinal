import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LogosComponent } from './componentes/logos/logos.component';
import { EncabezadoComponent } from './componentes/encabezado/encabezado.component';
import { RedesComponent } from './componentes/redes/redes.component';
import { FondoComponent } from './componentes/fondo/fondo.component';
import { PresentacionComponent } from './componentes/presentacion/presentacion.component';

@NgModule({
  declarations: [
    AppComponent,
    LogosComponent,
    EncabezadoComponent,
    RedesComponent,
    FondoComponent,
    PresentacionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
