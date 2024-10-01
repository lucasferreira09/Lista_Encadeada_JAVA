package Lista_Encadeada_Java.src;

import java.util.LinkedList;

public class ListaEncadeadaTest {

    public static void main(String[] args) {

        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        for (int i= 1; i <= 5; i++) {
            lista.adiciona(i);
        }

        lista.invert();

        System.out.println(lista);
        System.out.println(lista.getTamanho());
    }
}
