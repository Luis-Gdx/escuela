import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ListaDeseosService } from "../../app/services/lista-deseos.service";
import { Agregar } from "../agregar/agregar";
import { Detalles } from "../detalles/detalles";
/**
 * Generated class for the Pendientes page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-pendientes',
  templateUrl: 'pendientes.html',
})
export class Pendientes {

  constructor(private _listaDeseos: ListaDeseosService, private navCtrl: NavController, private navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Pendientes');
  }

  irAgregar() {
    this.navCtrl.push(Agregar);
  }

  verDetalles(lista, id) {
    this.navCtrl.push(Detalles, { lista, id });
  }

}
