import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ListaDeseosService } from "../../app/services/lista-deseos.service";
import { Detalles } from "../detalles/detalles";
/**
 * Generated class for the Terminados page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-terminados',
  templateUrl: 'terminados.html',
})
export class Terminados {

  constructor(private _listaDeseos: ListaDeseosService, private navCtrl: NavController, private navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Terminados');
  }

  verDetalles(lista, id) {
    this.navCtrl.push(Detalles, { lista, id });
  }

}
