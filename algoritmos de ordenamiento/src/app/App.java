package app;

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
        /*Tree tree = new Tree();
        int[] array = {7, 8, 56, 52, 3, 4, 2, 4, 87};
        tree.add(array);
        System.out.println("Pre orden");
        view(tree.preOrder());
        System.out.println("Post orden");
        view(tree.postOrder());
        System.out.println("int orden");
        view(tree.inOrder());*/
    }
}
