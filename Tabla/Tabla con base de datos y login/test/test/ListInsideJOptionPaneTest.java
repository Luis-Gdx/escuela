/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.JOptionPane;

/**
 *
 * @author Luis G
 */
public class ListInsideJOptionPaneTest {

    public static void main(String[] args) {
        Persona personas[] = new Persona[30];
        String nombres[] = new String[30];

        for (int i = 0; i < personas.length; i++) {
            personas[i] = new Persona("hola " + i, i);
        }
        Persona persona = (Persona) JOptionPane.showInputDialog(null, "Pick a printer", "Input", JOptionPane.QUESTION_MESSAGE, null, personas, personas[0]);
        System.out.println(persona);

    }
}

class Persona {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
