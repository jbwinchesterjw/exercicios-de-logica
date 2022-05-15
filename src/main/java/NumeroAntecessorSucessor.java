import java.util.Scanner;

public class NumeroAntecessorSucessor {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Informe o numero");
        int n1 = s.nextInt();
        int sucessor;
        int antecessor;
        sucessor = n1 + 1;
        antecessor = n1 - 1;
        System.out.print("numero digitado "+n1+" seu antecessor "+antecessor+" seu sucessor "+sucessor);
    }
}
