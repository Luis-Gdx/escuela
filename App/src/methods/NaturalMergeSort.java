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
public class NaturalMergeSort {

    private int[] b;
    private static final String NAME = "NaturalMergeSort";
    Lson lson = new Lson();

    public Lson sort(int[] array) {
        b = new int[array.length];
        int left = 0;
        int right = array.length - 1;
        boolean sorted = false;
        int l = 0;
        int r = right;

        do {
            sorted = true;
            left = 0;

            while (left < right) {
                l = left;
                while (l < right && array[l] <= array[l + 1]) {
                    l++;
                }
                r = l + 1;
                while (r == right - 1 || r < right && array[r] <= array[r + 1]) {
                    r++;
                }
                if (r <= right) {
                    merge(array, left, l, r);
                    sorted = false;
                }
                left = r + 1;
            }
        } while (!sorted);
        lson.add(NAME);
        lson.add(array);
        return lson;
    }

    private void merge(int[] a, int left, int middle, int right) {
        int l = left;
        int r = middle + 1;

        for (int i = left; i <= right; i++) {
            if (r > right || (l <= middle && a[l] <= a[r])) {
                b[i] = a[l++];
            } else if (l > middle || (r <= right && a[r] <= a[l])) {
                b[i] = a[r++];
            }
        }

        for (int i = left; i <= right; i++) {
            a[i] = b[i];
        }
    }

}
