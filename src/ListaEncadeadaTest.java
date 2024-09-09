package Lista_Encadeada_Java.src;

public class ListaEncadeadaTest {

    public static void main(String[] args) {

        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        for (int i= 1; i <= 5; i++) {
            lista.adiciona(i);
        }
    
        System.out.println(lista);
    }
}
