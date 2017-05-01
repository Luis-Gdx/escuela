import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';

//Services :v
import { ListaDeseosService } from "./services/lista-deseos.service";

//Pipes :v
import { PlaceHolderPipe } from "./pipes/placeholder.pipe";
import { PendientesPipe } from "./pipes/pendientes.pipe";

//Pages :v
import { Pendientes } from "../pages/pendientes/pendientes";
import { Terminados } from "../pages/terminados/terminados";
import { Agregar } from "../pages/agregar/agregar";
import { TabsPage } from '../pages/tabs/tabs';
import { Detalles } from "../pages/detalles/detalles";

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

@NgModule({
  declarations: [
    MyApp,
    PlaceHolderPipe,
    PendientesPipe,
    Pendientes,
    Terminados,
    Agregar,
    Detalles,
    TabsPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    Pendientes,
    Terminados,
    Agregar,
    Detalles,
    TabsPage
  ],
  providers: [
    ListaDeseosService,
    StatusBar,
    SplashScreen,
    { provide: ErrorHandler, useClass: IonicErrorHandler }
  ]
})
export class AppModule { }
