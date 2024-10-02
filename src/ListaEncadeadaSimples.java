package Lista_Encadeada_Java.src;

public class ListaEncadeadaSimples<T> {
    private Node<T> nodeInicial;
    private Node<T> nodeFinal;
    private int tamanho;


    // Adiciona no final
    public void adiciona(T elemento) {
        Node<T> node = new Node<>(elemento);

        if (this.tamanho == 0) {
            this.nodeInicial = node;
        } else {
            this.nodeFinal.setProximo(node);
        }
        this.nodeFinal = node;
        this.tamanho++;
    }

    // Adiciona em uma posição específica
    public void adiciona(int index, T elemento) {
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

    public void setValue(int index, T elemento) {
        if (this.tamanho == 0) {
            throw new RuntimeException("Lista Vazia");
        }
        if (index < 0 || index >= this.tamanho) {
            throw new IndexOutOfBoundsException("Índice Inválido!");
        }

        Node<T> node = this.getNode(index);
        node.setElemento(elemento);

    }

    // Verifica se um determinado elemento está na lista
    // Retornando True ou False
    public boolean contains(T elemento) {
        if (this.tamanho == 0) {
            return false;
        }

        Node<T> node = this.nodeInicial;
        while (node != null) {
            if (node.getElemento().equals(elemento)) {
                return true;
            }
            node = node.getProximo();
        }
        return false;
    }


    // Retorna True se o Primeiro elemento for removido
    public Boolean removeInicio() {
        if (this.tamanho == 0) {
            throw new RuntimeException("A Lista está vazia");
        }

        this.nodeInicial = this.nodeInicial.getProximo();
        this.tamanho--;

        if (this.tamanho == 0) {   // Depois de removido. Se o tamanho = 0
            this.nodeFinal = null; // Removemos a referência do Node Final
        }
        return true;
    }


    // Retorna True se o elemento Final for removido
    public Boolean removeFinal() {
        if (this.tamanho == 0) {
            throw new RuntimeException("A Lista está vazia");
        }


        Node<T> node = this.getNode(this.tamanho - 2); // Para antes do elemento Final da lista

        node.setProximo(null);
        this.nodeFinal = node;
        this.tamanho--;

        return true;
    }

    // Remove o elemento de qualquer posição
    public void remove(int index) {
        if (this.tamanho == 0) {
            throw new RuntimeException("A Lista está vazia");
        }
        if (index < 0 || index >= this.tamanho) {
            throw new IndexOutOfBoundsException("Índice Inválido!");
        }

        if (index == 0) { // Remove do Início
            this.removeInicio();
        } else if (index == this.tamanho - 1) { // Remove do Final
            this.removeFinal();
        } else { // Remove do Meio

            Node<T> nodeAtual = this.getNode(index-1); // Para um índice antes do Node escolhido

            Node<T> proximoNode = nodeAtual.getProximo().getProximo();
            nodeAtual.setProximo(proximoNode);
            this.tamanho--;
        }
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

    // inverte toda lista
    public void invert() {
        if (this.tamanho == 0 || this.tamanho == 1) {
            return;
        }

        ListaEncadeadaSimples<T> novaLista = new ListaEncadeadaSimples<>();
        Node<T> nodeAtual = this.nodeInicial;

        while (nodeAtual != null) {
            novaLista.adiciona(0, nodeAtual.getElemento()); // Sempre irá adicionar no início da lista
            nodeAtual = nodeAtual.getProximo();
        }
        this.nodeInicial = novaLista.nodeInicial;
        this.nodeFinal = novaLista.nodeFinal;
    }

    // Retorna o elemento, se o índice for válido
    public T getElemento(int index) {
        if (index >= this.tamanho || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = this.getNode(index);
        return node.getElemento();
    }

    // Retorna o índice do elemento, se estiver na lista
    public int getIndex(T elemento) {

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

    public int getTamanho() {
        return this.tamanho;
    }

    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Node<T> currentNode = this.nodeInicial;

        while (currentNode.getProximo() != null) {
            builder.append(currentNode.getElemento()).append(",");
            currentNode = currentNode.getProximo();
        }
        builder.append(currentNode.getElemento()).append("]"); // Print o elemento do último Node

        return builder.toString();
    }
}
