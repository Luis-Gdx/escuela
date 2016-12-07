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
public class QuickSort {

    //Codigo hecho por mrmikemcguire
    //Repositorio en github: https://github.com/mrmikemcguire/Quicksort-Int
    private static final String NAME = "QuickSort";
    Lson lson = new Lson();

    public Lson sort(int array[]) {
        lson.add(NAME);
        lson.add(quickSort(array, 0, array.length - 1));
        return lson;
    }

    private int[] quickSort(int array[], int left, int right) {
        int i, j;
        int pivot, temp;
        i = left;
        j = right;
        pivot = array[(left + right) / 2];

        do {
            while ((array[i] < pivot) && (i < right)) {
                i++;
            }

            while ((pivot < array[j]) && (j > left)) {
                j--;
            }

            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (left < j) {
            quickSort(array, left, j);
        }

        if (i < right) {
            quickSort(array, i, right);
        }
        return array;
    }
}

/*
 int i, j;
        int pivot, temp;
        i = left;
        j = right;
        pivot = array[(left + right) / 2];

        do {
            while ((array[i] < pivot) && (i < right)) {
                i++;
            }

            while ((pivot < array[j]) && (j > left)) {
                j--;
            }

            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (left < j) {
            qs(array, left, j);
        }

        if (i < right) {
            qs(array, i, right);
        }*/
