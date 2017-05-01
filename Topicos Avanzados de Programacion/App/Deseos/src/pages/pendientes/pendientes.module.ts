import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { Pendientes } from './pendientes';

@NgModule({
  declarations: [
    Pendientes,
  ],
  imports: [
    IonicPageModule.forChild(Pendientes),
  ],
  exports: [
    Pendientes
  ]
})
export class PendientesModule {}
