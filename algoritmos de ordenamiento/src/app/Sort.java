package app;

import config.ArrayConfig;
import lson.Lson;
import methods.*;

/**
 *
 * @author Luis G
 */
public class Sort extends ArrayConfig {

    public Lson bubble(int[] array) {
        BubbleSort bubble = new BubbleSort();
        return bubble.sort(array);
    }

    public Lson quickSort(int[] array) {
        QuickSort bubble = new QuickSort();
        return bubble.sort(array);
    }

    public Lson shell(int[] array) {
        ShellSort quickSort = new ShellSort();
        return quickSort.sort(array);
    }

    public Lson radix(int[] array) {
        Radix radix = new Radix();
        return radix.sort(array);
    }

    public Lson intercalation(int[] array1, int[] array2) {
        Intercalation intercalation = new Intercalation();
        return intercalation.sort(array1, array2);
    }

    public Lson directMerge(int[] array) {
        DirectMerge directMerge = new DirectMerge();
        return directMerge.sort(array);
    }

    public Lson naturalMerge(int[] array) {
        NaturalMerge naturalMerge = new NaturalMerge();
        return naturalMerge.sort(array);
    }
}
