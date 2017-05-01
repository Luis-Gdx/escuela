import { Component } from '@angular/core';

import { Pendientes } from '../pendientes/pendientes';
import { Terminados } from "../terminados/terminados";

@Component({
  templateUrl: 'tabs.html'
})
export class TabsPage {

  tab1Root = Pendientes;
  tab2Root = Terminados;

  constructor() {

  }
}
