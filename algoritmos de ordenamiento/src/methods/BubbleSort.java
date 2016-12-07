/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import lson.Lson;

/**
 *
 * @author Luis G
 */
public class BubbleSort {

    private static final String NAME = "Burbuja";

    public Lson sort(int[] array) {
        Lson lson = new Lson();
        int aux;
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length - 1; j++) {

                if (array[j] > array[j + 1]) {

                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;

                }
            }
        }
        lson.add(NAME);
        lson.add(array);
        return lson;
    }
}
