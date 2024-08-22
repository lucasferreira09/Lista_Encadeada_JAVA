package list;

public class Node<T> {
    private T element;
    private Node<T> next;

    public Node() { //Add the current Element
        this.element = element;
        this.next = null; //optional
    }

    public Node(T element) { //Add the current Element and the Next at the SAME TIME
        this.element = element;
        this.next = next; //the next Node
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Node{" +
                "element=" + element +
                ", next=" + next +
                '}';
    }
}

