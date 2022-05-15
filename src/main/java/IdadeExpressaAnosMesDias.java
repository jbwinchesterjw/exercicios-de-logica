import java.util.Scanner;

public class IdadeExpressaAnosMesDias {

    /**
     * Faça um algoritmo que leia a idade de uma pessoa expressa em anos, meses e dias e mostre-a expressa em dias.
     * Leve em consideração o ano com 365 dias e o mês com 30. (Ex: 3 anos, 2 meses e 15 dias = 1170 dias.)
     * @param args
     */
    public static void main(String[] args) {
        final short DIAS_NO_ANO = 365;
        final short DIAS_NO_MES = 30;
        short dias;
        short meses;
        short anos;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Informe a sua idade.");
        System.out.print("Anos: ");
        anos = leitor.nextShort();

        System.out.print("Meses: ");
        meses = leitor.nextShort();

        System.out.print("Dias: ");
        dias = leitor.nextShort();

        dias += (anos * DIAS_NO_ANO) + (meses * DIAS_NO_MES);

        System.out.println("\n\nA sua idade em dias é " + dias);
    }
}

