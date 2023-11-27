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
    static PessoaInterface pessoaInterface = new PessoaImplementacao();

    static String msgApenasNumeros= "Atenção digite apenas números!";

    static CursoInterface cursoInterface = new CursoImplementacao();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("Gerenciamento de alunos e professores qual deseja cadastrar? \n1 - Aluno \n2 - Professor\n3 - Curso");

            try {
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
                        logger.info("A Opção digitada é inválida!");
                }
            } catch (InputMismatchException exception) {
                logger.info(msgApenasNumeros);
            }
        }
    }

    private static void gerenciarAlunos() {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("Menu Gerenciar alunos\n1 - Cadastro \n2 - Atualizar\n3 - Excluir\n4 - Listar\n5 - Volata ao menu principal");
            opcao = input.nextInt();
            try {
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
                logger.info(msgApenasNumeros);
            }
        }
    }

    public static void cadastroDeAlunos() {
        Pessoa alunoPessoa = new Aluno("Joao", "Joao@", LocalDate.now());
        pessoaInterface.verificarEmail(alunoPessoa.getEmail());
        pessoaInterface.cadastrarPessoa(alunoPessoa);
    }

    public static void atualizarAluno() {
        listarAluno();
        System.out.println("Informe o código do aluno que deseja atualizar");
        int codigoAluno = input.nextInt();
        Pessoa alunoEncontradoPorCodigo = pessoaInterface.buscarPessoaPorCadigo(codigoAluno);
        if (alunoEncontradoPorCodigo != null) {
            Pessoa atualizarInformacoesAluno = new Aluno("Fulano Atualizado", "fulano@", LocalDate.now().minusMonths(6));
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
        pessoaInterface.listarAlunos();
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
                        break;
                    default:
                        logger.info("Opção invalida!");
                }
            } catch (InputMismatchException exception) {
                logger.info(msgApenasNumeros);
            }
        }
    }

    private static void castrarProfessor() {
        Pessoa professor = new Professor("Professor zica", "zica@", LocalDate.now());
        pessoaInterface.cadastrarPessoa(professor);
    }

    private static void atualizarProfessor() {
        listarProfessor();
        Pessoa professor = new Professor("Professor gente boa", "genteboa@", LocalDate.now().minusMonths(7));
        System.out.println("Informe o codigo do professor que deseja atualizar!");
        int codigo = input.nextInt();
        Pessoa professorEncontrado = pessoaInterface.buscarPessoaPorCadigo(codigo);
        if (professorEncontrado != null) {
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
        pessoaInterface.listarProfessores();
    }


    private static void gerenciarCursos() {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("Gerenciamento de curso\n1 - Cadastrar\n2 - Atualizar\n3 - Excluir\n4 - Listar\n5 - Vincular aluno ou professor ao curso\n6 - Menu principal");
            try {
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
                        vincularPessoasAoCurso();
                        break;
                    case 6:
                        menuPrincipal();
                        break;
                    default:
                        logger.info("A opção digitada e invalida!");
                }
            } catch (InputMismatchException exception) {
                logger.info(msgApenasNumeros);
            }
        }
    }

    private static void vincularPessoasAoCurso() {
        int opcao = 0;
        while (opcao != 3) {
            System.out.println("O que deseja fazer?\n1 - Vincular aluno ao curso\n2 - Vincular professor ao curso\n3 - Voltar para o menu de cursos");
            try {
                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        vincularAluno();
                        break;
                    case 2:
                        vincularProfessor();
                        break;
                    case 3:
                        gerenciarCursos();
                        break;
                    default:
                        logger.info("A opção digitada é inválida!");
                }
            } catch (InputMismatchException exception) {
                logger.info(msgApenasNumeros);
            }
        }
    }


    private static void vincularAluno() {
        List<Curso> cursoList = cursoInterface.listarCurso();
        System.out.println("Todos os nossos cursos cadastrados ! ");
        System.out.println(cursoList);
        System.out.println("Informe o código do curso que deseja adicionar alunos:");
        int codigoCurso = input.nextInt();
        System.out.println("Todos os nossos alunos cadastrado ! ");
        pessoaInterface.listarPessoa();
        Curso cursoEncontrado = cursoInterface.buscarCursoPorCodigo(codigoCurso);
        if (cursoEncontrado != null) {
            System.out.println("Informe o código do aluno que deseja adicionar ao curso de: " + cursoEncontrado.getNome());
            int codigoAluno = input.nextInt();

            Pessoa aluno = pessoaInterface.buscarPessoaPorCadigo(codigoAluno);
            if (aluno instanceof Aluno) {
                Curso curso = cursoInterface.buscarCursoPorCodigo(codigoCurso);
                if (curso != null) {
                    cursoInterface.vincularPessoasAoCurso(aluno, curso.getTotalAlunos(), curso.getCodigo());
                }

            } else {
                System.out.println("Aluno não encontrado ou não é um aluno válido.");
            }
        } else {
            System.out.println("Curso não encontrado.");
        }
    }

    private static void vincularProfessor() {
    }

    private static void casdastrarCurso() {
        int opcao = 0;
        System.out.println("Informe o nome do curso!");
        String nomeCurso = input.next();
        System.out.println("Qauntidade de alunos para esse curso ?");
        int quantidadeAluno = input.nextInt();
        Curso curso = new Curso(nomeCurso, quantidadeAluno, new ArrayList<>());
        cursoInterface.cadastroDeCurso(curso);

        while (opcao != 3) {
            System.out.println("Deseja adicionar algum aluno ou porfessor a esse curso ? \n1 - Sim\n2 - Não");
            try {
                opcao = input.nextInt();
                switch (opcao) {
                    case 1:
                        escolherAlunoProfessorASerVinculado();
                        break;
                    case 2:
                        gerenciarCursos();
                        break;
                    case 3:
                        logger.info("A opção digitada invalida!");
                        break;
                    default:
                }

            } catch (InputMismatchException exception) {
                logger.info(msgApenasNumeros);
            }

        }
    }

    private static void escolherAlunoProfessorASerVinculado() {
        int opcao = 0;
        while (opcao != 3) {
            System.out.println("O que deseja fazer?\n1 - Vincular aluno ao curso\n2 - Vincular professor ao curso\n3 - Voltar para o menu de cursos");
            try {
                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        vincularAluno();
                        break;
                    case 2:
                        vincularProfessor();
                        break;
                    case 3:
                        gerenciarCursos();
                        break;
                    default:
                        logger.info("A opção digitada é inválida!");
                }
            } catch (InputMismatchException exception) {
                logger.info(msgApenasNumeros);
            }
        }
    }

    private static void atualizarCurso() {
        Curso curso = new Curso("Angular", 15, new ArrayList<>());
        System.out.println("Informe qual código do curso deseja atualizar!");
        int codigo = input.nextInt();
        Curso cursoEcontraso = cursoInterface.buscarCursoPorCodigo(codigo);
        if (cursoEcontraso != null) {
            cursoInterface.atualizarCurso(codigo, curso.getNome(), curso.getTotalAlunos(), new ArrayList<>());
        }
    }

    private static void excluirCurso() {
        System.out.println("Informe o codigo do curso que deseja excluir!");
        int codigo = input.nextInt();
        cursoInterface.excluirCurso(codigo);
    }

    private static void listarCurso() {
        System.out.println("Todos os nossos cursos cadastrados !");
        List<Curso> cursoList = cursoInterface.listarCurso();
        System.out.println(cursoList);
    }


}




