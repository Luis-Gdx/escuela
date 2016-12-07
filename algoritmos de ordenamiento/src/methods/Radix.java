/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.util.*;
import lson.Lson;

/**
 *
 * @author Luis G
 */
public class Radix {

    //Added a constructor for future use
    private int modulo = 10;
    Lson lson = new Lson();
    private static final String NAME = "Radix";

    public void setModulo(int mod) {
        this.modulo = mod;
    }

    //Added a constructor for future use
    private int ofInterest = 1;

    public void setInterest(int interest) {
        this.ofInterest = interest;
    }

    //Quick way to get the maximum number of digits in the set
    private int max(int[] theArray) {
        int max = theArray[0];
        for (int i = 0; i < theArray.length; i++) {
            if (theArray[i] > max) {
                max = theArray[i];
            }
        }
        return max;
    }

    //Sort the array using Radix Sort logic
    public Lson sort(int[] array) {
        int significant = 0;
        int curVal = 0;
        LinkedList<Queue> lists = new LinkedList<>();
        Queue<Integer> queue;

        lists.clear();
        for (int i = 0; i < 10; i++) {
            queue = new LinkedList<>();
            lists.add(i, queue);
        }

        significant = String.valueOf(max(array)).length();

        for (int j = 1; j <= significant; j++) {
            Queue<Integer> thisQueue;
            for (int value : array) {
                curVal = value % this.modulo;
                curVal = curVal / this.ofInterest;
                thisQueue = lists.get(curVal);
                thisQueue.add(value);
                lists.set(curVal, thisQueue);
            }

            int k = 0;
            for (int i = 0; i < 10; i++) {
                thisQueue = lists.get(i);
                while (!thisQueue.isEmpty()) {
                    array[k] = thisQueue.remove();
                    k++;
                }
            }
            this.ofInterest = this.ofInterest * 10;
            this.modulo = this.modulo * 10;
        }
        lson.add(NAME);
        lson.add(array);
        return lson;
    }

}
