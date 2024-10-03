package Lista_Encadeada_Java.src;

public class ListaEncadeadaSimplesTest {

    public static void main(String[] args) {

        ListaEncadeadaSimples<Integer> lista = new ListaEncadeadaSimples<>();
        for (int i= 1; i <= 5; i++) {
            lista.adiciona(i);
        }

        lista.adiciona(1000);
        System.out.println(lista);
    }
}
