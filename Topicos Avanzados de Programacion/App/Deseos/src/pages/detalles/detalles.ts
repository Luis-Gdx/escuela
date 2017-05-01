import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController, Navbar } from 'ionic-angular';
import { Lista, ListaItem } from "../../app/clases/index";
import { ListaDeseosService } from "../../app/services/lista-deseos.service";
import { Agregar } from "../agregar/agregar";

/**
 * Generated class for the Detalles page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-detalles',
  templateUrl: 'detalles.html',
})
export class Detalles {

  id: number;
  lista: Lista;

  constructor(public listaDeseosService: ListaDeseosService, public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
    this.id = navParams.get("id");
    this.lista = navParams.get("lista");
    this.listaDeseosService.actualizarData();
  }

  @ViewChild(Navbar) navBar: Navbar;
  ionViewDidLoad() {
    this.navBar.backButtonClick = (e: UIEvent) => {
      let todosMarcados = true;
      for (let item of this.lista.items) {
        if (!item.completado) {
          todosMarcados = false;
          break;
        }
      }
      this.lista.terminada = todosMarcados;
      this.listaDeseosService.actualizarData();
      this.navCtrl.pop();
    }
    console.log('ionViewDidLoad Detalles');
  }

  actualizar(item: ListaItem) {
    item.completado = !item.completado;
    let todosMarcados = true;
    for (let item of this.lista.items) {
      if (!item.completado) {
        todosMarcados = false;
        break;
      }
    }
    this.lista.terminada = todosMarcados;
    this.listaDeseosService.actualizarData();
  }

  regresar() {
    let todosMarcados = true;
    for (let item of this.lista.items) {
      if (!item.completado) {
        todosMarcados = false;
        break;
      }
    }
    this.lista.terminada = todosMarcados;
    this.listaDeseosService.actualizarData();
    this.navCtrl.pop();
  }

  borrarItem() {
    let confirm = this.alertCtrl.create({
      title: this.lista.nombre,
      message: '¿Esta seguro que desea eliminar la lista?',
      buttons: ['Cancelar',
        {
          text: 'Eliminar',
          handler: () => {
            console.log('Agree clicked');
            this.listaDeseosService.eliminarLista(this.id);
            this.navCtrl.pop();
          }
        }
      ]
    });
    confirm.present();
  }

  editarItem() {
    this.navCtrl.push(Agregar, { lista: this.lista });
  }

}
