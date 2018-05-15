package tp04simulaciondecolas.Utils;


/**
 * TP04 Simulacion de Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Clase Lista generica
 */
public class List<T> {
    private Node root;
    private int size;

    public List() {
        root = new Node();
        size = 0;
    }

    private boolean isEmpty() {
        return root.value == null;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0) return null;
        return getHelper(index, root);
    }

    private T getHelper(int index, Node node) {
        if (node == null) return null;
        if (index == 0) return node.value;
        else return getHelper(index - 1, node.next);
    }

    public void add(T t) {
        if (t == null) return;
        addHelper(t, root);
    }

    private void addHelper(T t, Node node) {
        if (node.value == null) {
            node.value = t;
            node.next = new Node();
        }
        else addHelper(t, node.next);
    }

    @SuppressWarnings("unchecked")
    public String toString() {
        String result = "";
        if (isEmpty()) return result;
        return toStringHelper(result, root);
    }

    private String toStringHelper(String result, Node node) {
        if (node == null) return result;
        result += node.value;
        return toStringHelper(result, node.next);
    }

    private class Node {
        T value;
        Node next;

        public Node() {
            value = null;
            next = null;
        }
    }
}
