package senaiEtapa2_1;


import java.util.Scanner;

/**
 * Para a implementação da funcionalidade de busca de um usuário pelo nome, é necessário implementar uma função
 * que receba por parâmetro o nome de uma pessoa. Essa função erá verificar todas as posições da estrutura homogênia
 * até encontrar uma que coincida com o nome passado por parâmetro ou até finalizar a pesquisa sem emcontrar a pessoa
 * caso encontre, deverá apresentar o nome e a idade e sua posição, caso não emcontre deverar retorna -1. Além disso
 * deverár ser adicionado ao menu geral do sistema a opção 4- buscar usuário pelo nome, a qual deverá soliciatar o
 * nome do usuário para posteriomente chamar a função.
 */
public class BuscarUsuario {
    private Scanner opcaoMenu;
    private boolean execute;
    String[] nomes = {"joao", "ana", "maria", "jj"};
    //String[] nomes = new String[2];

    public static void main(String[] args) {
        new BuscarUsuario();
    }

    private BuscarUsuario() {
        Scanner input = new Scanner(System.in);
        String nome = "";
        opcaoMenu = new Scanner(System.in);
        execute = true;
        System.out.println("BEM VINDO");
        while (execute) {
            String opcao = menu();

            if (opcao.equalsIgnoreCase("p")) {
                System.out.println("informe o nome que deseja pesquisar ");
                nome = input.nextLine();
                buscarNomePessoa(nome);
            } else if (opcao.equalsIgnoreCase("l")) {
                listarCadastros();
            } else if (opcao.equalsIgnoreCase("e")) {
                System.out.println("informe o nome que deseja remover ");
                nome = input.nextLine();
                excluirUsuario(nome);
            } else if (opcao.equalsIgnoreCase("x")) {
                execute = false;
            } else {
                System.out.println("\nOpção Inválida ! Digite uma das opções do menu !!! \n");
            }
        }
    }

    private void listarCadastros() {
        if (nomes.length == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (int i = 0; i < nomes.length; i++) {
                String n = nomes[i];
                System.out.println("Cadastro número: " + i);
                System.out.println("\tNome: " + n + "" + i);
            }
            System.out.println("\nFim da lista\n");
        }
    }

    private String menu() {
        System.out.println("Selecione uma das opções:");
        System.out.println("P - Fazer pesquisa espesifica");
        System.out.println("E - Excluir nome especifico");
        System.out.println("L - Listar todos cadastrados");
        System.out.println("X - Sair do programa");
        return opcaoMenu.nextLine();
    }

    private void excluirUsuario(String nome) {
        if (nomes.length == 0) {
            System.out.println("\n Não existem cadastros !!!\n");
        } else {
            for (int i = 0; i < nomes.length; i++) {
                if (nomes[i].equals(nome)) {
                    int i1 = nomes[i].length() - 1;
                    System.out.println("Nome excluido com sucesso" + nome + " sua posição e :" + i1);
                }
            }
        }
    }

    private String buscarNomePessoa(String nome) {
        int i;
        for (i = 0; i < nomes.length; i++) {
            if (nomes[i].equals(nome)) {
                System.out.println("Nome encontrado " + nome + " sua posição e :" + i);
                return nome;
            }
        }
        if (!nomes[i  - nomes.length].equals(nome)) {
            System.out.println("o nome que vc pesquisou " + nome + " não existe na lista, posição do index " + (i - nomes.length - 1));
        }
        return nome;
    }

   private String textInput(String label) {
        System.out.println(label);
        return opcaoMenu.nextLine();
    }
}