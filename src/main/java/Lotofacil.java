import java.util.*;

public class Lotofacil {

    public static void main(String[] args) {
        List<Integer> numerosAleatorios = gerarNumerosAleatoriosOrdenados(15, 1, 25);

        System.out.println("Lista de números aleatórios em ordem crescente:");
        imprimirNumeros(numerosAleatorios);
    }

    public static List<Integer> gerarNumerosAleatoriosOrdenados(int quantidade, int min, int max) {
        if (quantidade > (max - min + 1)) {
            throw new IllegalArgumentException("A quantidade de números solicitada é maior do que o intervalo especificado.");
        }

        Set<Integer> numerosAleatorios = new HashSet<>();
        Random random = new Random();

        while (numerosAleatorios.size() < quantidade) {
            int numero = random.nextInt(max - min + 1) + min;
            numerosAleatorios.add(numero);
        }

        List<Integer> listaOrdenada = new ArrayList<>(numerosAleatorios);
        Collections.sort(listaOrdenada);

        return listaOrdenada;
    }

    public static void imprimirNumeros(List<Integer> numeros) {
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
