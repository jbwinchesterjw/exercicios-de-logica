package controle_vacina_covid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VacinacaoCovi_d {
    /**
     * https://pt.stackoverflow.com/questions/35010/como-fazer-increment-em-vari%C3%A1veis
     * A vacinação contra o Covid-19 evoluiu muito no ano de 2021. Para 2022 ao que tudo indica doses de reforço serão necessárias para controle da pandemia.
     * Com a ajuda da tecnologia, o controle de vacinas são todas digitalizadas, inclusive a partir de um aplicativo você mesmo pode consultar as vacinas que você tomou.
     * <p>
     * Imagine então que você trabalha na área de desenvolvimento de software do seu estado, e você foi designado para registrar os dados de aplicação das vacinas.
     * Nesta aplicação a pessoa responsável precisará pegar do paciente as informações como nome, cpf, nome da vacina aplicada, número do lote e a data da aplicação.
     * <p>
     * Este programa deve ser capaz de cadastrar as informações de aplicação de vacina, que em resumo são:
     * - Código (você fará o controle, não será digitado pelo usuário)
     * - Nome
     * - CPF
     * - Vacina
     * - Data (pode ser tratada como String)
     * - Numero Lote
     * <p>
     * Logo após o cadastro o programa deverá disponibilizar outros dois recursos, um deles é um relatório geral de aplicação, que trará todas as informações das aplicações
     * em tela no seguinte modelo:
     * Código: 0
     * Nome: Rogerio Napoleao Júnior
     * CPF: 111.111.111-11
     * Vacina: Pfizer
     * Data: 01/05/2022
     * Numero do Lote: 123123123
     * ==================================
     * Código: 1
     * Nome: Joao da Silva
     * CPF: 111.111.111-11
     * Vacina: Coronavac
     * Data: 10/05/2022
     * Numero do Lote: 333222333
     * ==================================
     * <p>
     * O outro recurso necessário é busca por CPF, ao usuário digitar o CPF o programa deve fazer uma buscar e mostrar em tela apenas o CPF consultado,
     * caso não exista uma informação “CPF não encontrado” deve ser mostrado na tela.
     * <p>
     * Para controlar este programa deverá ter um menu de opções como abaixo:
     * 1 - Cadastrar Vacina
     * 2 - Listar Aplicações
     * 3 - Consultar por CPF
     * 4 - Sair
     */
    private Scanner opcaoMenu;
    private boolean execute;
    private static int i = 0;
    private List<DadosUsuarioVacina> dadosPessoa;

    public static void main(String[] args) {
        new VacinacaoCovi_d();
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }

    private VacinacaoCovi_d() {
        Scanner input = getScanner();
        opcaoMenu = new Scanner(System.in);
        execute = true;
        dadosPessoa = new ArrayList<DadosUsuarioVacina>();
        System.out.println("Bem Vindo ao controle de vacinação");
        String cpf;

        while (execute) {
            String opcao = menu();
            if (opcao.equals("1")) {
                cadastrar();
            } else if (opcao.equals("2")) {
                listarCadastros();
            } else if (opcao.equals("3")) {
                System.out.println("informe o CPF que deseja pesquisar !");
                cpf = input.next();
                pesquisarPorCPF(cpf);
            } else if (opcao.equals("4")) {
                execute = false;
            } else {
                System.out.println("Opção Inválida ! Digite uma das opções do menu !!!");
            }
        }
    }

    private String menu() {
        System.out.println("Selecione uma das opções:");
        System.out.println("1 - Cadastrar Vacina");
        System.out.println("2 - Listar Aplicações");
        System.out.println("3 - Consultar por CPF");
        System.out.println("4 - Sair");
        return opcaoMenu.nextLine();
    }

    private String pesquisarPorCPF(String cpf) {
        if (dadosPessoa.isEmpty()) {
            System.out.println("Não há registro na lista!");
        } else {
            for (i = 0; i < dadosPessoa.size(); i++) {
                if (dadosPessoa.get(i).getCpf().equals(cpf)) {
                    System.out.println("CPF encontrado : " + cpf);
                    listarDadosVacinação();
                    return cpf;
                }
            }
            if (!dadosPessoa.get(dadosPessoa.size() - 1).equals(cpf)) {
                System.out.println("o CPF que vc pesquisou " + cpf + " não existe na lista");
            }
        }
        return cpf;
    }

    private String meuInput(String string) {
        System.out.print(string);
        return opcaoMenu.nextLine();
    }

    private void listarCadastros() {
        if (dadosPessoa.size() == 0) {
            System.out.println("Não existem cadastros !!!");
        } else {
            System.out.println("Lista de Cadastros");
            for (i = 0; i < dadosPessoa.size(); i++) {
                listarDadosVacinação();
            }
            System.out.println("Fim da lista");
        }
    }

    private void listarDadosVacinação() {
        DadosUsuarioVacina p = dadosPessoa.get(i);
        System.out.println("Cadastro número: " + i);
        System.out.println("Nome: " + p.getNome());
        System.out.println("CPF: " + p.getCpf());
        System.out.println("Vacina: " + p.getVacina());
        System.out.println("Data: " + p.getDataRegistro());
        System.out.println("Lote: " + p.getLote());
        System.out.println("=======================================");
    }

    private void cadastrar() {
        boolean cadastrando = true;
        while (cadastrando) {
            DadosUsuarioVacina dadosUsuarioVacina = new DadosUsuarioVacina();
            dadosUsuarioVacina.setNome(meuInput("Nome: "));
            dadosUsuarioVacina.setCpf(meuInput("CPF: "));
            dadosUsuarioVacina.setVacina(meuInput("Vacina: "));
            dadosUsuarioVacina.setDataRegistro(meuInput("Data do registro: "));
            dadosUsuarioVacina.setLote(meuInput("Lote: "));

            cadastrando = isCadastrando(cadastrando, dadosUsuarioVacina);
        }
    }

    private boolean isCadastrando(boolean cadastrando, DadosUsuarioVacina dadosUsuarioVacina) {
       String cadastrar = meuInput("Adicionar cadastro (S/N) ?");
        if (cadastrar.equalsIgnoreCase("s")) {
            System.out.println("Cadastro adicionado !!!");
            dadosPessoa.add(dadosUsuarioVacina);
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
        return cadastrando;
    }
}
