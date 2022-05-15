import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ExercioLogicaFacudade {
    /***
     * Imagine que você mora em um prédio onde contém diversos apartamentos, e na reunião de condomínio houve uma reclamação
     * por parte dos moradores do gasto excessivo de água, fazendo assim que o custo do condomínio aumentasse.
     * Para isso é preciso identificar o apartamento que mais consumiu para que possa verificar se foi algum vazamento ou outra situação parecida.
     * Para resolver o problema você se prontificou a criar um algoritmo onde irá ler N marcações de quantidade de litros de água de cada apartamento,
     * no final da leitura deverá mostrar na tela o valor mais alto em metros cúbicos de água que foi consumido.
     * Onde:
     * - Cada 1000 litros de água representa 1 metro cúbico;
     * O que entregar?
     * Faça o algortimo ler uma séria de N marcações em litros, mostrando na tela o maior valor em metro cúbico;
     * Neste caso:
     * N - representa a quantidade de vezes que será inserido uma marcação de litros gasto, ou seja a quantidade de apartamentos,
     * essa informação deverá ser lida pelo algoritmo.
     * *Atenção: o algoritmo deve ser escrito em pseudocódigo (portugol) e submetido para correção em formato txt
     * (documento de texto – notepad) ou doc (documento do Microsoft Word). Algoritmos sem indentação terão desconto em pontuação.
     * Serão avaliadas a corretude semântica e sintática, bem como a eficiência do código.
     */
    private static int valor[] = new int[0];
    private static int i = 0;
    private static int j = 0;

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Informe quantos apartamento existe no predio");
//        int amountApartment = input.nextInt();
//        expensesForApartments = new int[amountApartment];
//        int biggerExpense = 0;
//        int menor = 0;
//        //biggerExpense = getMaior(input, expensesForApartments, biggerExpense);
//        //BigDecimal biggestSpentCubicMeters = BigDecimal.valueOf(biggerExpense).setScale(2, RoundingMode.HALF_EVEN);
//        //int i = 0;
//        for (i = 0; i < expensesForApartments.length; i++) {
//            System.out.print("Digite os gastos em litros do apartamento " + (i + 1) + "°: ");
//            expensesForApartments[i] = input.nextInt();
//            if (expensesForApartments[i] > biggerExpense) {
//                biggerExpense = (expensesForApartments[i] / 1000);
//            }
//        System.out.println("Maior gasto ate o momento e do apartamento: " + (i) + "° com o total de " + biggerExpense + ": metros cubicos");
//        }
////        for (int j = 0; j < expensesForApartments.length; j++) {
////            if(expensesForApartments[j] < menor){
////                menor = expensesForApartments[j];
////            }
////        }
////        BigDecimal biggestSpentCubicMeters = BigDecimal.valueOf(biggerExpense).setScale(2, RoundingMode.HALF_EVEN);
//    }

        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos AP tem o Predio");
        int qt = sc.nextInt();
        valor = new int[qt];
        int maior = valor[0], menor = Integer.MAX_VALUE;

        for (i = 0; i < valor.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º valor: ");
            valor[i] = sc.nextInt();
            if (valor[i] > maior) {
                maior = valor[i] / 1000;
            }
        }
        for (j = 0; j < valor.length; j++) {
            if (valor[j] < menor) {
                menor = valor[j] / 1000;
            }
        }
        BigDecimal valorMaiorAr = BigDecimal.valueOf(maior).setScale(2, RoundingMode.FLOOR);
        BigDecimal valorMenorAr = BigDecimal.valueOf(menor).setScale(2, RoundingMode.FLOOR);
        System.out.println("Maior valor = " + valorMaiorAr);
        System.out.println("Menor valor = " + valorMenorAr);
    }
}
