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
public class Intercalation {

    private static final String NAME = "Intercalación";
    Lson lson = new Lson();

    public Lson sort(int[] array1, int[] array2) {
        int[] array3 = new int[array1.length + array2.length];
        int i, j, k;
        for (i = j = k = 0; i < array1.length && j < array2.length; k++) {
            if (array1[i] < array2[j]) {
                array3[k] = array1[i];
                i++;
            } else {
                array3[k] = array2[j];
                j++;
            }
        }
        for (; i < array1.length; i++, k++) {
            array3[k] = array1[i];
        }
        for (; j < array2.length; j++, k++) {
            array3[k] = array2[j];
        }
        lson.add(NAME);
        lson.add(array3);
        return lson;
    }
}
