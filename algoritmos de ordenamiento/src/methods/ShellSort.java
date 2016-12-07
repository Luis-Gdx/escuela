/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import config.ArrayConfig;
import lson.Lson;

/**
 *
 * @author Luis G
 */
public class ShellSort extends ArrayConfig {

    private static final String NAME = "ShellSort";
    Lson lson = new Lson();

    //Código creado por santhoshpkumar
    //Repositorio en github del código original: https://github.com/santhoshpkumar/ShellSort
    public Lson sort(int[] array) {
        String[][] data = new String[2][2];
        for (int gap = array.length / 2; gap > 0; gap = (gap == 2 ? 1 : (int) (gap / 2.2))) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int cmpItem = array[j];
                for (; j >= gap && cmpItem < array[j - gap]; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = cmpItem;
            }
        }
        lson.add(NAME);
        lson.add(array);
        return lson;
    }
}
