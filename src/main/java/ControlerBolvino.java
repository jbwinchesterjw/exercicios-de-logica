import java.util.Scanner;

public class ControlerBolvino {
    public static void main(String[] args) {
        int i = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Informe quantos cadastro serão feitos");
        int numeroDigitado = input.nextInt();
        int[] vlido = new int[numeroDigitado];
        int[] vpar = new int[numeroDigitado];
        int[] vimpar = new int[numeroDigitado];
        int[][] vetores = new int[numeroDigitado][numeroDigitado];
        System.out.println("Informe os numeros para cadastro");
        for (i = 0; i < numeroDigitado; i++) {
            int n = input.nextInt();
            vlido[i] = n;
            vetores[vlido[i] % 2][i] = vlido[i];
        }
        System.out.print("Pasto com gado de numeros par: ");
        for (i = 0; i < vpar.length; i++) {
            System.out.println(vetores[0][i]);
        }
        System.out.print("Pasto com gados de numeros impares: ");
        for (i = 0; i < vimpar.length; i++) {
            System.out.println(vetores[1][i]);
        }
    }
}
