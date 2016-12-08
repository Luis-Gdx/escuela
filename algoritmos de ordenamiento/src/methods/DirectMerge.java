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
public class DirectMerge {

    private static final String NAME = "Mezcla directa";
    Lson lson = new Lson();

    public Lson sort(int[] array) {
        lson.add(NAME);
        lson.add(directMergeSort(array));
        return lson;
    }

    private int[] directMergeSort(int[] array) {
        int i, j, k;
        if (array.length > 1) {
            int leftElements = array.length / 2;
            int rightElements = array.length - leftElements;
            int[] leftArray = new int[leftElements];
            int[] rightArray = new int[rightElements];
            for (i = 0; i < leftElements; i++) {
                leftArray[i] = array[i];
            }
            for (i = leftElements; i < leftElements + rightElements; i++) {
                rightArray[i - leftElements] = array[i];
            }
            leftArray = directMergeSort(leftArray);
            rightArray = directMergeSort(rightArray);
            i = 0;
            j = 0;
            k = 0;
            while (leftArray.length != j && rightArray.length != k) {
                if (leftArray[j] < rightArray[k]) {
                    array[i] = leftArray[j];
                    i++;
                    j++;
                } else {
                    array[i] = rightArray[k];
                    i++;
                    k++;
                }
            }
            while (leftArray.length != j) {
                array[i] = leftArray[j];
                i++;
                j++;
            }
            while (rightArray.length != k) {
                array[i] = rightArray[k];
                i++;
                k++;
            }
        }
        return array;
    }
}
