import java.util.Scanner;

public class NumeroDecrescente {
    public static void main(String[] srgs){
        Scanner s = new Scanner(System.in);

        System.out.print("Informe o numero");
        int n1 = s.nextInt();
        /*for(int i = 10; i <= 10; ++i) {
            System.out.println(i);
            for(i=0; i<=num; num--) {

  System.out.println(num);
        }*/
        for (int i = 0; i <= n1; n1--){
            System.out.print(n1);
        }
    }
}
