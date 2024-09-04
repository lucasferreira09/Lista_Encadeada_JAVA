package Lista_Encadeada_Java.src;

public class Node<T> {
    private T elemento;
    private Node<T> proximo;

    public Node() {
        this.elemento = elemento;
        this.proximo = null;
    }

    public Node(T element) { // Construtor que adiciona o elemento atual
        this.elemento = element;
    }
    public Node(T elemento, Node<T> proximo) { // Construtor que adiciona o elemento atual e o próximo elemento
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Node<T> getProximo() {
        return proximo;
    }

    public void setProximo(Node<T> proximo) {
        this.proximo = proximo;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Node{" +
                "elemento=" + elemento +
                ", próximo=" + proximo +
                '}';
    }
}

