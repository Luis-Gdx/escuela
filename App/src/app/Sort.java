package app;

import config.ArrayConfig;
import lson.Lson;
import methods.*;

/**
 *
 * @author Luis G
 */
public class Sort extends ArrayConfig {

    public Lson shell(int[] array) {
        ShellSort shell = new ShellSort();
        return shell.sort(array);
    }

    public Lson naturalMerge(int[] array) {
        NaturalMergeSort naturalMerge = new NaturalMergeSort();
        return naturalMerge.sort(array);
    }
}
