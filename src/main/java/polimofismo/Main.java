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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
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
        Pessoa alunoPessoa1 = new Aluno("Joao", "Jb@", LocalDate.now().minusMonths(10));
        pessoaInterface.verificarEmail(alunoPessoa.getEmail());
        pessoaInterface.cadastrarPessoa(alunoPessoa);
        pessoaInterface.cadastrarPessoa(alunoPessoa1);
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
        Pessoa professor1 = new Professor("Professor gente boa", "nice@", LocalDate.now());
        pessoaInterface.cadastrarPessoa(professor);
        pessoaInterface.cadastrarPessoa(professor1);
    }

    private static void atualizarProfessor() {
        listarProfessor();
        Pessoa professor = new Professor("Professor gente boa2", "genteboa2@", LocalDate.now().minusMonths(7));
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
                        cursoInterface.listarCurso();
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
        System.out.println("Todos os nossos cursos cadastrados ! ");
        List<Curso> cursoList = cursoInterface.listarCurso();
        System.out.println("Informe o código do curso que deseja adicionar alunos:");
        int codigoCurso = input.nextInt();

        // Verificar se o código do curso é válido
        Curso cursoEncontrado = null;
        for (Curso curso : cursoList) {
            if (curso.getCodigo() == codigoCurso) {
                cursoEncontrado = curso;
                break;
            }
        }

        if (cursoEncontrado != null) {
            System.out.println("Todos os nossos alunos cadastrados ! ");
            pessoaInterface.listarAlunos();

            System.out.println("Informe o código do aluno que deseja adicionar ao curso de: " + cursoEncontrado.getNome());
            int codigoAluno = input.nextInt();

            Pessoa aluno = pessoaInterface.buscarPessoaPorCadigo(codigoAluno);
            if (aluno instanceof Aluno) {
                cursoInterface.vincularPessoasAoCurso(aluno, cursoEncontrado.getTotalAlunos(), cursoEncontrado.getCodigo());
                System.out.println("Aluno vinculado ao curso com sucesso!");
            } else {
                System.out.println("Aluno não encontrado ou não é um aluno válido.");
            }
        } else {
            System.out.println("Curso não encontrado.");
        }
    }

    private static void vincularProfessor() {
        System.out.println("Todos os nossos cursos cadastrados ! ");
        cursoInterface.listarCurso();
        System.out.println("Informe o código do curso que deseja adicionar alunos:");
        int codigoCurso = input.nextInt();
        System.out.println("Todos os nossos professores cadastrados ! ");
        pessoaInterface.listarProfessores();
        Curso cursoEncontrado = cursoInterface.buscarCursoPorCodigo(codigoCurso);
        if (cursoEncontrado != null) {
            System.out.println("Informe o código do professor que deseja adicionar ao curso de: " + cursoEncontrado.getNome());
            int codigoAluno = input.nextInt();

            Pessoa professor = pessoaInterface.buscarPessoaPorCadigo(codigoAluno);
            if (professor instanceof Professor) {
                Curso curso = cursoInterface.buscarCursoPorCodigo(codigoCurso);
                if (curso != null) {
                    cursoInterface.vincularPessoasAoCurso(professor, curso.getTotalAlunos(), curso.getCodigo());
                }

            } else {
                System.out.println("Professor não encontrado ou não é um professor válido.");
            }
        } else {
            System.out.println("Curso não encontrado.");
        }
    }

    private static void casdastrarCurso() {
        int opcao = 0;
        LocalTime horarioInicio = LocalTime.of(7, 30);
        LocalTime horarioFinal = LocalTime.of(11, 30);
        LocalTime horarioInicio1 = LocalTime.of(8, 30);
        LocalTime horarioFinal1 = LocalTime.of(12, 00);
        Curso curso = new Curso("Java", 10, new ArrayList<>(), horarioInicio, horarioFinal);
        Curso curso1 = new Curso("Flutter", 10, new ArrayList<>(), horarioInicio1, horarioFinal1);
        cursoInterface.cadastroDeCurso(curso);
        cursoInterface.cadastroDeCurso(curso1);

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
        LocalTime horarioInicio = LocalTime.of(8, 00);
        LocalTime horarioFinal = LocalTime.of(12, 00);
        Curso curso = new Curso("Angular", 15, new ArrayList<>(), horarioInicio, horarioFinal);
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

}




