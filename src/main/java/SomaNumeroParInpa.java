import java.util.Scanner;

public class SomaNumeroParInpa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int somaImp = 0, multPar = 1;

        for (int i = 0; i <= 30; ++i) {  //conta de 0 a 30

            if (i % 2 == 0) {

                multPar *= i;  //multPar é multiplicado com i
                System.out.println("multiplicação "+multPar);
            } else {

                somaImp += i;  //somaImp é somado com i

            }
            System.out.println("soma dos impas "+somaImp);
        }

    }
}
