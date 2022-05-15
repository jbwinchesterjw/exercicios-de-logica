package atividadesenai.buscaU_situacao2_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BuscaPorPessoaET2 {

    private static boolean execute;
    private static Scanner opcaoMenu;
    private static ArrayList<String> nomes = new ArrayList<>(Arrays.asList("joao", "ana", "maria", "jj"));
    private static int i = 0;

    public static void main(String[] args) {
        buscaPorPessoa();
    }

    private static Scanner getScanner() {
        Scanner input = new Scanner(System.in);
        opcaoMenu = new Scanner(System.in);
        execute = true;
        System.out.println("\nBEM VINDO\n");
        return input;
    }

    private static void buscaPorPessoa() {
        Scanner input = getScanner();
        String nome;

        while (execute) {
            int opcao = menu();
            switch (opcao) {
                case 4:
                    System.out.println("informe o nome que deseja pesquisar ");
                    nome = input.next();
                    buscarNomePessoa(nome);
                    break;
                case 5:
                    System.out.println("informe o nome que deseja excluir ");
                    nome = input.next();
                    excluirUsuario(nome);
                    break;
                case 6:
                    execute = false;
                    System.out.println("\nObrigado por usar nosso sistema!!! \n");
                    break;
                default:
                    System.out.println("\nOpção Inválida ! Digite uma das opções do menu !!! \n");
            }
        }
    }

    private static int menu() {
        int opcao = 0;
        do {
            try {
                System.out.println("Selecione uma das opções:");
                System.out.println("4 - Fazer pesquisa espesifica");
                System.out.println("5 - Remover usuário");
                System.out.println("6 - Encerrar programa");
                return opcaoMenu.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("ATENÇÃO ..... Digite apenas número(S) !");
            }
            opcaoMenu.nextLine();
        } while (opcao == 0);
        return opcaoMenu.nextInt();
    }

    private static String buscarNomePessoa(String nome) {
        if (nomes.isEmpty()) {
            System.out.println("Não há nomes na lista!");
        } else {
            for (i = 0; i < nomes.size(); i++) {
                if (nomes.get(i).equals(nome)) {
                    System.out.println("Nome encontrado : " + nome + " sua posição e : " + i);
                    return nome;
                }
            }
            if (!nomes.get(nomes.size() - 1).equals(nome)) {
                System.out.println("o nome que vc pesquisou " + nome + " não existe na lista, posição do index " + (i - nomes.size() - 1));
            }
        }
        return nome;
    }

    private static String excluirUsuario(String nome) {
        if (nomes.isEmpty()) {
            System.out.println("Não há nomes na lista !");
        } else {
            for (i = 0; i < nomes.size(); i++) {
                if (nomes.get(i).equals(nome)) {
                    nomes.remove((i));
                    System.out.println("Lista " + nomes);
                    System.out.println("Nome excluido com sucesso: " + nome);
                    return nome;
                }
            }
            if (!nomes.get(nomes.size() - 1).equals(nome)) {
                System.out.println("o nome que vc pesquisou " + nome + " não existe na lista ! Dados da lista" + nomes);
            }
        }
        return nome;
    }
}