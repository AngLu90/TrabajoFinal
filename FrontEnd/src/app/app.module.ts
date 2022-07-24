import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LogosComponent } from './componentes/logos/logos.component';
import { EncabezadoComponent } from './componentes/encabezado/encabezado.component';
import { FondoComponent } from './componentes/fondo/fondo.component';
import { PresentacionComponent } from './componentes/presentacion/presentacion.component';
import { TrabajoComponent } from './componentes/trabajo/trabajo.component';
import { EducacionComponent } from './componentes/educacion/educacion.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { ConocimientosComponent } from './componentes/conocimientos/conocimientos.component';
import { ProyectoComponent } from './componentes/proyecto/proyecto.component';
import { HttpClientModule} from '@angular/common/http';
import { HmComponent } from './componentes/hm/hm.component';
import { LoguearseComponent } from './componentes/loguearse/loguearse.component';

@NgModule({
  declarations: [
    AppComponent,
    LogosComponent,
    EncabezadoComponent,
    FondoComponent,
    PresentacionComponent,
    TrabajoComponent,
    EducacionComponent,
    ConocimientosComponent,
    ProyectoComponent,
    HmComponent,
    LoguearseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
