package atividadesenai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroPesso {
    private Scanner opcaoMenu;
    private boolean execute;
    private List<Pessoa> dadosPessoa;

    public static void main(String[] args) {
        new CadastroPesso();
    }

    private CadastroPesso() {
        opcaoMenu = new Scanner(System.in);
        execute = true;
        dadosPessoa = new ArrayList<Pessoa>();
        System.out.println("BEM VINDO");

        while (execute) {
            String opcao = menu();
            if (opcao.equals("1")) {
                cadastrar();
            } else if (opcao.equals("2")) {
                listarCadastros();
            } else if (opcao.equals("3")) {
                execute = false;
            } else {
                System.out.println("Opção Inválida ! Digite uma das opções do menu !!!");
            }
        }
    }

    private String menu() {
        System.out.println("Selecione uma das opções:");
        System.out.println("1 - Cadastrar novo usuário");
        System.out.println("2 - Listar todos usuários cadastrados");
        System.out.println("3 - Sair do programa");
        return opcaoMenu.nextLine();
    }

    private String meuInput(String string) {
        System.out.println(string);
        return opcaoMenu.nextLine();
    }

    private void listarCadastros() {
        if (dadosPessoa.size() == 0) {
            System.out.println("Não existem cadastros !!!");
        } else {
            System.out.println("Lista de Cadastros");
            for (int i = 0; i < dadosPessoa.size(); i++) {
                Pessoa p = dadosPessoa.get(i);
                System.out.println("Cadastro número: " + i);
                System.out.println("Nome: " + p.getNome());
                System.out.println("Idade: " + p.getIdade());
            }
            System.out.println("Fim da lista");
        }
    }

    private void cadastrar() {

        boolean cadastrando = true;

        while (cadastrando) {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(meuInput("Nome:"));
            pessoa.setIdade(meuInput("Idade"));

            String cadastrar = meuInput("Adicionar cadastro (S/N) ?");
            if (cadastrar.equalsIgnoreCase("s")) {
                System.out.println("Cadastro adicionado !!!");
                dadosPessoa.add(pessoa);
            } else if (cadastrar.equalsIgnoreCase("n")) {
                System.out.println("Cadastro ignorado !!!");
            } else {
                System.out.println("\nOpção inválida !!! \n");
            }

            String continua = meuInput("Continuar cadastrando (S/N) ?");
            if (continua.equalsIgnoreCase("N")) {
                cadastrando = false;
            } else if (continua.equalsIgnoreCase("s")) {
            } else {
                System.out.println("\nOpção inválida !!! \n");
                cadastrando = false;
            }
        }
    }
}
