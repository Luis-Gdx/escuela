import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ListaItem, Lista } from "../../app/clases/index";
import { AlertController } from 'ionic-angular';
import { ListaDeseosService } from "../../app/services/lista-deseos.service";

/**
 * Generated class for the Agregar page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-agregar',
  templateUrl: 'agregar.html',
})
export class Agregar {

  nombreLista: string = "";
  nombreItem: string = "";
  edit: boolean = false;

  items: ListaItem[] = [];

  constructor(private listaDeseos: ListaDeseosService, public navCtrl: NavController, public navParams: NavParams, private alertCtrl: AlertController) {
    if (navParams.get("lista")) {
      this.edit = true;
      this.nombreLista = navParams.get("lista").nombre;
      this.items = navParams.get("lista").items;
    }
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Agregar');
  }

  agregar() {
    if (this.nombreItem.length == 0) {
      return;
    }
    let item = new ListaItem();
    item.nombre = this.nombreItem;
    this.items.push(item);
    this.nombreItem = "";
  }

  borrarItem(id: number) {
    this.items.splice(id, 1);
    this.listaDeseos.actualizarData();
  }

  guardarLista() {
    if (this.nombreLista.length == 0) {
      let alert = this.alertCtrl.create({
        title: 'Nombre de la lista',
        subTitle: 'El nombre de la lista es necesario!',
        buttons: ['OK']
      });
      alert.present();
      return;
    }
    if (!this.edit) {
      let lista = new Lista(this.nombreLista);
      lista.items = this.items;
      this.listaDeseos.agregarLista(lista);
    }
    this.navCtrl.pop();
  }

}
