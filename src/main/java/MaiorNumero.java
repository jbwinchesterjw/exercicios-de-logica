import java.util.Scanner;

public class MaiorNumero {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
            System.out.print(" informe o primeiro numero");
            int n1 = s.nextInt();
            System.out.print("informe o segundo numero");
            int n2 = s.nextInt();
            if (n1 > n2){
                System.out.print("o numero maior entre os dois e " +n1);
            }else {
                System.out.print("o numero maior entre os dois e " +n2);
            }

    }
}
