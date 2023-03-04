import java.util.Random;

public class NumerosMegaSena {
    //private static Scanner scanner;

    public static void main(String[] args) {
        int numero, i, j;
        int[] mega = new int[6];

        Random random = new Random();

        geraNumeroAleatorioSemRepetição(mega, random);

        ordenaNumerosOrdemCrescente(mega);

        esvreNumerosNaTela(mega);
    }

    private static void esvreNumerosNaTela(int[] mega) {
        int i;
        for (i = 0; i < mega.length; i++) {
            System.out.print(mega[i] + " ");
        }
    }

    private static void ordenaNumerosOrdemCrescente(int[] mega) {
        int numero;
        int j;
        int i;
        for (i = 0; i < mega.length; i++) {
            for (j = i + 1; j < mega.length; j++) {
                if (mega[i] > mega[j]) {
                    numero = mega[i];
                    mega[i] = mega[j];
                    mega[j] = numero;
                }
            }
        }
    }

    private static void geraNumeroAleatorioSemRepetição(int[] mega, Random random) {
        int j;
        int i;
        int numero;
        for (i = 0; i < mega.length; i++) {
            numero = random.nextInt(60) + 1;
            for (j = 0; j < mega.length; j++) {
                if (numero == mega[j] && j != i) {
                    numero = random.nextInt(60) + 1;
                } else {
                    mega[i] = numero;
                }
            }
        }
    }
}
