package lson;

public class Lson {

    private Node first;
    private Node last;
    private int id = -1;
    private String name = "";
    private int[] array;

    public Lson() {
        first = null;
    }

    public Lson(String name) {
        this.name = name;
    }

    public void addFirst(int[] dato) {
        id++;
        Node nuevo = new Node(dato, id);
        nuevo.link = first;
        first = nuevo;
        order();
    }

    public void addFirst(Object dato) {
        id++;
        Node nuevo = new Node(dato, id);
        nuevo.link = first;
        first = nuevo;
        order();
    }

    public void addListFirst(Lson dato) {
        id++;
        Node nuevo = new Node(dato, id);
        nuevo.link = first;
        first = nuevo;
        order();
    }

    public void add(int[] array) {
        this.array = array;
    }

    public void add(Object dato) {
        Node n;
        if (!isNode(first)) {
            addFirst(dato);
        } else {
            id++;
            n = first;
            while (isNode(n.link)) {
                n = n.link;
            }
            Node nuevo = new Node(dato, id);
            n.link = nuevo;
        }
    }

    public void add(Lson dato) {
        Node n;
        if (!isNode(first)) {
            addListFirst(dato);
        } else {
            id++;
            n = first;
            while (isNode(n.link)) {
                n = n.link;
            }
            Node nuevo = new Node(dato, id);
            n.link = nuevo;
        }
    }

    public boolean isNode(Node e) {
        return e != null;
    }

    public int size() {
        return this.id + 1;
    }

    public void order() {
        Node n = first;
        try {
            for (int i = 0; i < this.size() + 1; i++) {
                n.id = i;
                if (!isNode(n.link)) {
                    last = n;
                }
                n = n.link;
            }
        } catch (Throwable e) {
        }
    }

    public Object getElementById(int id) {
        Node n = first;
        if (this.id == -1) {
            System.out.println("La lista esta vacia alv :v");
        } else {
            while (isNode(n)) {
                if (n.id == id) {
                    return n.data;
                } else {
                    n = n.link;
                }
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getArray() {
        return this.array;
    }
}
