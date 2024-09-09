package Lista_Encadeada_Java.src;

public class ListaEncadeada<T> {
    private Node<T> nodeInicial;
    private Node<T> nodeFinal;
    private int tamanho;

    public void adiciona(T elemento) { // Adiciona no final
        Node<T> node = new Node<>(elemento);

        if (this.tamanho == 0) {
            this.nodeInicial = node;
        } else {
            this.nodeFinal.setProximo(node);
        }
        this.nodeFinal = node;
        this.tamanho++;
    }

    public void adiciona(int index, T elemento) { // Adiciona em uma posição específica
        if (index < 0 || index > this.tamanho) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> novoNode = new Node<>(elemento);

        if (index == 0) { // Adiciona no início
            if (this.nodeInicial == null) {
                this.nodeInicial = novoNode;
                this.nodeFinal = novoNode;
            } else {
                novoNode.setProximo(this.nodeInicial);
                this.nodeInicial = novoNode;
            }
            this.tamanho++;

        } else if (index == this.tamanho) { // Adiciona no Final
            this.adiciona(elemento);

        } else { // Adiciona no Meio
            Node<T> nodeAtual = this.getNode(index - 1);
            Node<T> proximo = nodeAtual.getProximo();
            nodeAtual.setProximo(novoNode);
            novoNode.setProximo(proximo);
            this.tamanho++;
        }
    }


    // Somente a classe pode acessar esse método, retorna o Node
    private Node<T> getNode(int index) {
        if (index < 0 || index >= this.tamanho) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = this.nodeInicial;
        for (int i = 0; i < index; i++) {
            node = node.getProximo();
        }
        return node;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public Boolean removeInicio() { // Retorna True se o Primeiro elemento for removido
        if (this.tamanho == 0) {
            throw new RuntimeException("A Lista está vazia");
        }

        this.nodeInicial = this.nodeInicial.getProximo();
        this.tamanho--;

        if (this.tamanho == 0) {   // Depois que removi. Se o tamanho = 0
            this.nodeFinal = null; // removemos a referência do Node Final
        }
        return true;
    }

    public Boolean removeFinal() { // Retorna True se o elemento Final for removido
        if (this.tamanho == 0) {
            throw new RuntimeException("A Lista está vazia");
        }


        Node<T> node = this.getNode(this.tamanho - 2); // Para antes do elemento Final da lista

        node.setProximo(null);
        this.nodeFinal = node;
        this.tamanho--;

        return true;
    }

    public void limparLista() {
        if (this.tamanho == 0) { 
            return;
        }

        Node<T> currentNode = this.nodeInicial;
        while (currentNode != null) {
            Node<T> nextNode = currentNode.getProximo();
            currentNode.setElemento(null);   // É preciso percorrer a lista, e excluir cada elemento  
            currentNode.setProximo(null);     // Por causa do Garbage Collector
            currentNode = nextNode;
        }
        this.nodeInicial = null;
        this.nodeFinal = null;
        this.tamanho = 0;

    }

    public T getElementIndex(int index) {
        if (index >= this.tamanho || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = this.getNode(index);
        return node.getElemento();
    }


    public int buscarElemento(T elemento) {

        int index = 0;
        Node<T> currentNode = this.nodeInicial;

        while (currentNode != null) {

            if (currentNode.getElemento().equals(elemento)) {
                return index;
            }
            index++;
            currentNode = currentNode.getProximo();
        }
        return -1;
    }


    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Node<T> currentNode = this.nodeInicial;

        int x = 0;
        while (x < this.tamanho - 1) { // Para antes do último Node
            builder.append(currentNode.getElemento()).append(",");
            currentNode = currentNode.getProximo();
            x++;
        }
        builder.append(currentNode.getElemento()).append("]"); // Print o elemento do último Node

        return builder.toString();
    }
}
