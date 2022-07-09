package abastecimentoaeronave;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/***
 * Imagine que voce trabalhe na área de Tecnologia de uma companhia aérea de grande porte e foi solicitado a sua área que criasse um algoritmo
 * para controle de abastecimento das aeronaves antes dos voos. Um Boeing 737-800 por exemplo, pode gastar em média 3,6 litros por km de voo. O
 * gasto de uma aeronave de grande porte é tanto que a medição muda de eixo, sendo utilizado litros por quilômetros, diferente do que estamos
 * acostumados a calcular nos automóveis que é quilômetros por litro. Um trecho de 1100km, como por exemplo de São Paulo a Porto Alegre
 * precisaria de 3960 litros, sem contar a margem de segurança e outos fatores que podem alterar a quantidade.
 *
 * Para criação do algoritmo solicitado deverão ser considerados os seguintes dados para o calculo desejado, são eles:
 *     - Média da aeronave em litros por quilômetros
 *     - Capacidade máxima em litros do tanque
 *     - Quantidade de quilômetros do trecho planejado
 *     - Quantidade de quilômetros do trecho alternativo
 *     - Quantidade de combustível já na aeronave
 *
 * O algoritmo deve conter as seguintes regras
 *     - Uma aeronave deve sempre ser abastecida considerando o trecho planejado + trecho alternativo, visto que se o aeroporto de destino estiver com problemas,
 *     uma rota alternativa deverá ser realizada.
 *     - Além do trecho total, uma margem de 30% de combustível deverá ser adicionada, para que qualquer emergência a aeronave esteja com uma quantidade segura de combustível.
 *     - Se o trecho total mais a margem de segurança, extrapolarem a capacidade máxima de combustível do tanque da aeronave, uma mensagem de alerta deve ser mostrada na tela,
 *     dizendo a seguinte mensagem “Voo Reprovado, reveja seu planejamento.”. Caso contrário mostrar "Voo Aprovado, bom voo!"
 *     - Se o tanque suportar o trecho total mais a margem de segurança o algoritmo deverá mostrar na tela o valor do trecho principal, trecho alternativo,
 *     total do trecho com a margem de segurança, quantidade de combustível necessária para o trecho e quantidade necessária de abastecimento.
 *     - Use sub-rotinas para isolar as lógicas do algoritmo
 *
 * Sequencia lógica do algoritmo
 *     - Leitura dos dados
 *     - Somar trecho planejado + trecho alternativo
 *     - Adicionar margem de segurança
 *     - Calcular a quantidade de combustível
 *     - Verificar se a quantidade de combustível comporta na aeronave
 *     - Verificar o quanto de combustível será necessário para abastecimento.
 *     - Mostrar resultados.
 */
public class AbastecimentoAeronaves {
    private static boolean execute;
    private static Scanner opcaoMenu;

    public static void main(String[] args) {
        abastecimentoAeroNaves();
    }

    private static Scanner getScanner() {
        Scanner input = new Scanner(System.in);
        opcaoMenu = new Scanner(System.in);
        execute = true;
        System.out.println("\nBem vindo ao abastecimento das aeronaves \n");
        return input;
    }

    private static int menu() {
        int opcao = 0;
        do {
            try {
                System.out.println("Informe qual das aeronaves presentes em nosso aeroporto deseja abastecer!");
                System.out.println("1 - Boeing 737-800");
                System.out.println("2 - Encerrar programa");
                return opcaoMenu.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("ATENÇÃO ..... Digite apenas número(S) !");
            }
            opcaoMenu.nextLine();
        } while (opcao == 0);
        return opcaoMenu.nextInt();
    }

    private static void abastecimentoAeroNaves() {
        Scanner input = getScanner();
        while (execute) {
            int opcao = menu();
            switch (opcao) {
                case 1:
                    abasterAeronave747_800(input);
                    break;
                case 2:
                    execute = false;
                    System.out.println("\nObrigado por usar nosso sistema!!! \n");
                    break;
                default:
                    System.out.println("\nOpção Inválida ! Digite uma das opções do menu !!! \n");
            }
        }
    }

    private static void abasterAeronave747_800(Scanner input) {
        BigDecimal capacidadeMaximaTanque = new BigDecimal("26020.00").setScale(2, RoundingMode.HALF_UP);
        BigDecimal mediaLitros = new BigDecimal("3.60").setScale(2, RoundingMode.HALF_UP);
        System.out.println("Aeronave escolhida -> " + Aeronave.Boeing737_800);
        System.out.println("Média da aeronave em litros por quilômetros: " + mediaLitros);
        System.out.println("Capacidade máxima em litros do tanque para essa aeronave e: " + capacidadeMaximaTanque);
        System.out.println("Quantidade de quilômetros do trecho planejado");
        BigDecimal kmDoTrajetoPlanejado = input.nextBigDecimal();
        System.out.println("Quantidade de quilômetros do trecho alternativo");
        BigDecimal kmTrechoAlternativo = input.nextBigDecimal();
        System.out.println("Adicionado 30% a mas no tanque: " + securityMarginPercentageValue(kmDoTrajetoPlanejado) + " Litros");
        System.out.println("Quantidade de combustível já na aeronave");
        BigDecimal qtCombustivelNaAeronave = input.nextBigDecimal();

        double flightStatus = getFlightStatus(mediaLitros, kmTrechoAlternativo, kmDoTrajetoPlanejado, qtCombustivelNaAeronave);
        if (flightStatus > 26020.00) {
            System.out.println("Atenção........Voo Reprovado! As configurações ultrapassam o limiti da capacidade maxima do tanque" + flightStatus);
        } else {
            System.out.println("Vou a provado! " + flightStatus+" o tanque suporta o combustivel necessario para a viagem");
            System.out.println("Trecho principal: "+kmDoTrajetoPlanejado+" K");
            System.out.println("Trecho alternativo: "+kmTrechoAlternativo+" Km");
            System.out.println("Total do trecho com a margem de segurança: "+(kmDoTrajetoPlanejado.add(kmTrechoAlternativo))+" Km");
            System.out.println("Quantidade de combustível necessária para o trecho: "+(kmDoTrajetoPlanejado.multiply(mediaLitros))+" L");
            System.out.println("Quantidade necessária de abastecimento: "+(capacidadeMaximaTanque.subtract(securityMarginPercentageValue(kmDoTrajetoPlanejado).subtract(qtCombustivelNaAeronave)))+" L");
        }
    }

    private static double getFlightStatus(BigDecimal mediaLitros, BigDecimal kmTrechoAlternativo, BigDecimal kmDoTrajetoPlanejado, BigDecimal qtCombustivelNaAeronave) {
        double kmTotalTanqueCheio = kmDoTrajetoPlanejado.multiply(mediaLitros).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double kmTotalMargemSeguranca = kmTrechoAlternativo.multiply(mediaLitros).setScale(2, RoundingMode.HALF_UP).doubleValue();

        return kmTotalTanqueCheio + kmTotalMargemSeguranca + qtCombustivelNaAeronave.doubleValue();
    }

    private static BigDecimal securityMarginPercentageValue(BigDecimal kmDoTrajetoPlanejado) {
        return kmDoTrajetoPlanejado.multiply(BigDecimal.valueOf(30))//
                .divide(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP);
    }

}
