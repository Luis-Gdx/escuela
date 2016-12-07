package lson;

public class Node {

    Node link;
    int id;
    Object data;
    Lson list;

    public Node(Object data, int id) {
        this.data = data;
        this.link = null;
        this.id = id;
    }

    public Node(Node node, Object data, int id) {
        this.data = data;
        this.link = node;
        this.id = id;
    }

    public Node(Lson data, int id) {
        this.list = data;
        this.link = null;
        this.id = id;
    }

    public Node(Node node, Lson data, int id) {
        this.list = data;
        this.link = node;
        this.id = id;
    }
}
