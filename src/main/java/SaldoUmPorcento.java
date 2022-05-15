import java.util.Scanner;

public class SaldoUmPorcento {
    /**
     * Informar um saldo e imprimir o saldo com reajuste de 1%.
     */
    public static void main(String [] args){
        Scanner entradaDeDados = new Scanner(System.in);
        double valorComDesconto;
        System.out.print("Qual o valor da compra ?");
        double valorDaCompra = entradaDeDados.nextDouble();
        System.out.print("Quanto % deseja atribuir de desconto ?");
        double valorDoDesconto = entradaDeDados.nextDouble();
        valorComDesconto = valorDaCompra - (valorDaCompra * valorDoDesconto) / 100;

        System.out.println("Valor da compra sem desconto foi "+ valorDaCompra);
        System.out.println("Valor da compra com o desconto e "+valorComDesconto);
        System.out.println("Valor do desconto foi "+valorDoDesconto+" %");

        /*double valorOriginal, porcentagem, valorComAcrecimoPorcentagem;

        Scanner dadosEntrada = new Scanner(System.in);

        System.out.print("Imforme o valor que deseja acrescentar a porcentagem !");
        valorOriginal = dadosEntrada.nextDouble();
        System.out.print("Imforme a porcentagem que deseja acrescentar !");
        porcentagem = dadosEntrada.nextDouble();
        /**
         * para obter a porcentagem de um determinado numero baste fazer v = (x * y) / 100
         * para
         *
        valorComAcrecimoPorcentagem = valorOriginal - (valorOriginal * porcentagem) / 100;
        System.out.print(valorComAcrecimoPorcentagem);*/
    }
}
