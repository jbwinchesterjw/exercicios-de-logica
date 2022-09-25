import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opercao;
        System.out.println("informe a operação + * / - ");
        opercao = scanner.nextLine();

        if (opercao.equals("+")){
            int soma = 1 + 3;
            System.out.println("A soma e : "+ soma);
        }
        if (opercao.equals("/")){
            double divisao = 10 / 2;
            System.out.println("A divisão e :"+ divisao);
        }
        if (opercao.equals("*")){
            int multiplicacao = 2 * 3;
            System.out.println("A multiplicação e :"+ multiplicacao);
        }
        if (opercao.equals("-")){
            int subitracao = 4 - 1;
            System.out.println("A subitração e: "+subitracao);
        }
    }
}
