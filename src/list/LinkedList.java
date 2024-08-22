package list;

public class LinkedList<T> {
    private Node<T> startNode;
    private Node<T> finalNode;
    private int size;

    public void addElement(T element) { //Start
        Node<T> node = new Node<>(element);
        if (this.size == 0) {
            this.startNode = node;
        } else {
            this.finalNode.setNext(node);
        }
        this.finalNode = node;

        this.size++;
    }

    public void addElementIndex(int index, T element) { //Any position
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<>(element);

        if (index == 0) { //Start
            newNode.setNext(this.startNode);
            this.startNode = newNode;

        } else if (index == this.size) { //Final
            this.addElement(element);

        } else { // In the middle
            Node<T> currentNode = this.startNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }

            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            this.size++;
        }

    }

    public int getSize() {
        return this.size;
    }

    public void removeStart() {

        if (this.size == 0) {
            throw new RuntimeException("Empty List");

        } else if (this.size == 1) {
            this.startNode = null;
            this.finalNode = null;
            this.size--;
        } else {
            this.startNode = this.startNode.getNext();
            this.size--;
        }

    }

    public void clearList() {
        if (this.size == 0) {
            return;
        } //when the list is empty

        Node<T> currentNode = this.startNode;
        while (currentNode != null) {
            Node<T> nextNode = currentNode.getNext();
            currentNode.setElement(null);
            currentNode.setNext(null);
            currentNode = nextNode;
        }
        this.startNode = null;
        this.finalNode = null;
        this.size = 0;

        /*
        for (Node<T> current = this.startNode; current != null;) {
            Node<T> next = current.getNext();
            current.setElement(null);
            current.setNext(null);
            current = next;
        }
         */


    }

    public T searchIndex(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = this.startNode;
        for (int x = 0; x < index; x++) { //While x != index, do this!
            current = current.getNext();
        }
        return current.getElement();

    }


    public int searchElement(T element) {

        int index = 0;
        Node<T> currentNode = this.startNode;

        while (currentNode != null) {

            if (currentNode.getElement().equals(element)) {
                return index;
            }
            index++;
            currentNode = currentNode.getNext();
        }
        return -1;
    }




    public String toString() {
        if (this.size == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Node<T> currentNode = this.startNode;

        int x = 0;
        while (x < this.size - 1) { //Stop before the final Node
            builder.append(currentNode.getElement()).append(",");
            currentNode = currentNode.getNext();
            x++;
        }
        builder.append(currentNode.getElement()).append("]");//Print the final Node's Element

        return builder.toString();
    }
}
