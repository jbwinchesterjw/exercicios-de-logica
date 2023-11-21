package polimofismo;


import polimofismo.aluno.Aluno;
import polimofismo.curso.Curso;
import polimofismo.curso.CursoInterface;
import polimofismo.curso.impl.CursoImplementacao;
import polimofismo.pessoa.Pessoa;
import polimofismo.pessoa.PessoaInterface;
import polimofismo.pessoa.impl.PessoaImplementacao;
import polimofismo.professor.Professor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());
    static PessoaInterface pessoaInterface = (PessoaInterface) new PessoaImplementacao();

    static CursoInterface cursoInterface = new CursoImplementacao();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("Gerenciamento de alunos e professores qual deseja cadastrar? \n1 - Aluno \n2 - Professor\n3 - Curso");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    gerenciarAlunos();
                    break;
                case 2:
                    gerenciarProfessores();
                    break;
                case 3:
                    gerenciarCursos();
                    break;
                case 4:
                    break;
                default:
                    logger.info("A Opção digitada e invalida!");
            }
        }
    }

    private static void gerenciarAlunos() {
        int opcao = 0;
        while (opcao != 6) {

            System.out.println("Menu Gerenciar alunos\n1 - Cadastro \n2 - Atualizar\n3 - Excluir\n4 - Listar\n5 - Volata ao menu principal");
            try {
                opcao = input.nextInt();
                switch (opcao) {
                    case 1:
                        cadastroDeAlunos();
                        break;
                    case 2:
                        atualizarAluno();
                        break;
                    case 3:
                        excluirAluno();
                        break;
                    case 4:
                        listarAluno();
                        break;
                    case 5:
                        menuPrincipal();
                        break;
                    default:
                        logger.info("Opção invalida!");
                        break;
                }
            } catch (InputMismatchException exception) {
                logger.info("Atenção digite apenas números!");
            }
        }
    }

    public static void cadastroDeAlunos() {
        Pessoa alunoPessoa = new Aluno("jb@", "Joao", LocalDate.now());
        Pessoa alunoPessoa1 = new Aluno("jack@", "Jack Winchester", LocalDate.now());
        Pessoa alunoPessoa2 = new Aluno("jW@", "Jb Winchester", LocalDate.now());

        pessoaInterface.cadastrarPessoa(alunoPessoa);
        pessoaInterface.cadastrarPessoa(alunoPessoa1);
        pessoaInterface.cadastrarPessoa(alunoPessoa2);
        System.out.println("======================\u001B[32mAluno Cadastrado com sucesso!\u001B[0m======================");
    }

    public static void atualizarAluno() {
        listarAluno();
        System.out.println("Informe o código do aluno que deseja atualizar");
        int codigoAluno = input.nextInt();
        Boolean alunoEncontradoPorCodigo = pessoaInterface.buscarPessoaPorCadigo(codigoAluno);
        if (alunoEncontradoPorCodigo.equals(Boolean.TRUE)) {
            Pessoa atualizarInformacoesAluno = new Aluno("Fulana Atualizado", "fulano@", LocalDate.now().minusMonths(6));
            pessoaInterface.atualizarPessoa(codigoAluno, atualizarInformacoesAluno.getNome(),
                    atualizarInformacoesAluno.getEmail(),//
                    atualizarInformacoesAluno.getDatanascimento());
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    public static void excluirAluno() {
        System.out.println("Informe o codigo do aluno que deseja excluir!");
        int codigo = input.nextInt();
        pessoaInterface.excluirPessoa(codigo);
    }

    public static void listarAluno() {
        System.out.println("Listar de alunos cadastrados!");
        List<Pessoa> listarAlunos = pessoaInterface.listarAlunos();
        System.out.println(listarAlunos);
    }


    public static void gerenciarProfessores() {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("Menu gerenciar professor!\n1 - Cadastrar\n2 - Atualizar\n3 - Excluir\n4 - Listar\n5 - Menu principal");
            try {
                opcao = input.nextInt();
                switch (opcao) {
                    case 1:
                        castrarProfessor();
                        break;
                    case 2:
                        atualizarProfessor();
                        break;
                    case 3:
                        excluirProfessor();
                        break;
                    case 4:
                        listarProfessor();
                        break;
                    case 5:
                        menuPrincipal();
                    default:
                        logger.info("Opção invalida!");
                }
            } catch (InputMismatchException exception) {
                logger.info("Atenção digite apenas numeros!");
            }
        }
    }

    private static void castrarProfessor() {
        Pessoa professor = new Professor("Professor zica", "zica@", LocalDate.now());
        pessoaInterface.cadastrarPessoa(professor);
        System.out.println("======================\u001B[32mProfessor Cadastrado com sucesso!\u001B[0m======================");
    }

    private static void atualizarProfessor() {
        listarProfessor();
        Pessoa professor = new Professor("Professor gente boa", "genteboa@", LocalDate.now().minusMonths(7));
        System.out.println("Informe o codigo do professor que deseja atualizar!");
        int codigo = input.nextInt();
        Boolean professorEncontrado = pessoaInterface.buscarPessoaPorCadigo(codigo);
        if (professorEncontrado.equals(Boolean.TRUE)) {
            pessoaInterface.atualizarPessoa(codigo, professor.getNome(), professor.getEmail(), professor.getDatanascimento());
            System.out.println("Professor atualiazado com sucesso!");
        } else {
            logger.info("Não foi encontrado nem um professor com esse código!");
        }
    }

    private static void excluirProfessor() {
        listarProfessor();
        System.out.println("Informe o código do professor que deseja excluir");
        int codigo = input.nextInt();
        pessoaInterface.excluirPessoa(codigo);
    }

    private static void listarProfessor() {
        System.out.println("Professores cadastrados!");
        List<Pessoa> listarProfessores = pessoaInterface.listarProfessores();
        System.out.println(listarProfessores);
    }


    private static void gerenciarCursos() {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n1 - Cadastrar\n2 - Atualizar\n3 - Excluir\n4 - Listar");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    casdastrarCurso();
                    break;
                case 2:
                    atualizarCurso();
                    break;
                case 3:
                    excluirCurso();
                    break;
                case 4:
                    listarCurso();
                    break;
                case 5:
                    menuPrincipal();
                    break;
                default:
                    logger.info("A opção digitada e invalida!");
            }
        }
    }

    private static void casdastrarCurso() {
        Curso curso = new Curso("Java", 10, new ArrayList<>());
        cursoInterface.cadastroDeCurso(curso);
    }

    private static void atualizarCurso() {
        Curso curso = new Curso("Angular", 15, new ArrayList<>());
        System.out.println("Informe qual código do curso deseja atualizar!");
        int codigo = input.nextInt();
        Boolean cursoEcontraso = cursoInterface.buscarCursoPorCodigo(codigo);
        if (cursoEcontraso.equals(Boolean.TRUE)) {
            cursoInterface.atualizarCurso(codigo, curso.getNome(), curso.getTotalAlunos(), new ArrayList<>());
        }
    }

    private static void excluirCurso() {
        System.out.println("Informe o codigo do curso que deseja excluir!");
        int codigo = input.nextInt();
        cursoInterface.excluirCurso(codigo);
    }

    private static void listarCurso() {
        System.out.println("Cursos cadastrados !");
        cursoInterface.listarCurso();
    }


}



