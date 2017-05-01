import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { Terminados } from './terminados';

@NgModule({
  declarations: [
    Terminados,
  ],
  imports: [
    IonicPageModule.forChild(Terminados),
  ],
  exports: [
    Terminados
  ]
})
export class TerminadosModule {}
