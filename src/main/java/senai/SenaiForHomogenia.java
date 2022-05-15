package senai;

import atividadesenai.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SenaiForHomogenia {
    private Scanner opcaoMenu;
    private boolean execute;
    private List<Pessoa> dadosPessoa;

    public static void main(String[] args) {
        new SenaiForHomogenia();
    }

    private SenaiForHomogenia() {
        //String nome = "";
        opcaoMenu = new Scanner(System.in);
        execute = true;
        dadosPessoa = new ArrayList<Pessoa>();

        System.out.println("BEM VINDO AO CADASTRO DE PESSOAS");

        while (execute) {
            String opcao = menu();

            if (opcao.equalsIgnoreCase("n")) {
                cadastrar();
            } else if (opcao.equalsIgnoreCase("l")) {
                listarCadastros();
            } else if (opcao.equalsIgnoreCase("x")) {
                execute = false;
            } else {
                System.out.println("\nOpção Inválida ! Digite uma das opções do menu !!! \n");
            }
        }
    }

    private String menu() {
        System.out.println("Selecione uma das opções:");
        System.out.println("N - Novo cadastro");
        System.out.println("L - Listar cadastros");
        System.out.println("P - Pesquisa especifica");
        System.out.println("D - Deletar");
        System.out.println("X - Sair");
        return opcaoMenu.nextLine();
    }

    private void cadastrar() {
        boolean cadastrando = true;

        while (cadastrando) {
            System.out.println("Cadastro de Usuário");
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(textInput("Nome:"));

            String cadastrar = textInput("Adicionar cadastro (S/N) ?");
            if (cadastrar.equalsIgnoreCase("s")) {
                System.out.println("Cadastro adicionado !!!");
                dadosPessoa.add(pessoa);
            } else if (cadastrar.equalsIgnoreCase("n")) {
                System.out.println("Cadastro ignorado !!!");
            } else {
                System.out.println("\nOpção inválida seu noob, vou ignorar o cadastro só pra você ter que digitar denovo !!! \n");
            }

            String continua = textInput("Continuar cadastrando (S/N) ?");
            if (continua.equalsIgnoreCase("N")) {
                cadastrando = false;
            } else if (continua.equalsIgnoreCase("s")) {
                // se for s sai do if e volta para o inicio do while
            } else {
                System.out.println("\nOpção inválida seu noob, eu vou sair só porque você não colabora !!! \n");
                cadastrando = false;
            }
        }
    }

    private void listarCadastros() {
        if (dadosPessoa.size() == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (int i = 0; i < dadosPessoa.size(); i++) {
                Pessoa d = dadosPessoa.get(i);
                System.out.println("Cadastro número: " + i);
                System.out.println("\tNome: " + d.getNome());
                //System.out.println("\tLogin: " + d.getLogin());
                //System.out.println("\tCargo: " + d.getCargo() + "\n");
            }
            System.out.println("\nFim da lista\n");
        }
    }

    private String textInput(String label) {
        System.out.println(label);
        return opcaoMenu.nextLine();
    }


}
