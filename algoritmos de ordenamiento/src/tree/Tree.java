/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author Luis G
 */
public class Tree {

    private static Node root;
    private int[] data;
    private int index = 0;
    private int arraySize;

    public Tree() {
        root = null;
    }

    public void add(int[] data) {
        root = null;
        arraySize = data.length;
        for (int i = 0; i < data.length; i++) {
            Node nuevo = new Node(data[i]);
            if (isNode(root)) {
                Node n = root;
                Node aux;
                while (true) {
                    aux = n;
                    if (data[i] < n.data) {
                        n = n.left;
                        if (!isNode(n)) {
                            aux.left = nuevo;
                            break;
                        }
                    } else {
                        n = n.right;
                        if (!isNode(n)) {
                            aux.right = nuevo;
                            break;
                        }
                    }
                }
            } else {
                root = nuevo;
            }
        }
    }

    private void pre(final Node root) {
        if (isNode(root)) {
            this.data[index] = root.data;
            index++;
            pre(root.left);
            pre(root.right);
        }
    }

    private void in(final Node root) {
        if (isNode(root)) {
            in(root.left);
            data[index] = root.data;
            index++;
            in(root.right);
        }
    }

    private void post(final Node root) {
        if (isNode(root)) {
            post(root.left);
            post(root.right);
            data[index] = root.data;
            index++;
        }
    }

    public int[] preOrder() {
        this.data = new int[arraySize];
        pre(this.getRoot());
        return getData();
    }

    public int[] inOrder() {
        this.data = new int[arraySize];
        in(this.getRoot());
        return getData();
    }

    public int[] postOrder() {
        this.data = new int[arraySize];
        post(this.getRoot());
        return getData();
    }

    public int[] getData() {
        index = 0;
        return data;
    }

    private boolean isNode(Node node) {
        return node != null;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
}
