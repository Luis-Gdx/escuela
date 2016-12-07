package app;

import java.util.Arrays;
import methods.Radix;
import tree.Tree;

/**
 *
 * @author Luis G
 */
public class App {

    public static void view(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        SortApp app = new SortApp();
        app.setVisible(true);
        /*Radix radix = new Radix();
        int[] array = {43, 37, 597, 98, 73, 214, 436, 100, 67, 512};
        System.out.println(Arrays.toString(array) + " - Start");
        int[] inOrder = radix.sort(array);
        System.out.println(Arrays.toString(inOrder) + " - Final");*/

    }
}
