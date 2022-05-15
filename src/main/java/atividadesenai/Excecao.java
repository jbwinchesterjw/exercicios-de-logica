package atividadesenai;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excecao {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int numero = 0;
        do {
            try {
                System.out.print("Digite um numero: ");
                numero = ler.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ops... você digitou caracteres. Precisamos que digite apenas números.");
            }
            ler.nextLine();
        } while (numero == 0);

        System.out.println(numero);
    }
}
