package polimofismo.curso.impl;


import polimofismo.aluno.Aluno;
import polimofismo.curso.Curso;
import polimofismo.curso.CursoInterface;
import polimofismo.curso.repository.CursoRepository;
import polimofismo.pessoa.Pessoa;
import polimofismo.pessoa.repository.PessoaRepository;
import polimofismo.professor.Professor;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CursoImplementacao implements CursoInterface {

    CursoRepository cursoRepository = new CursoRepository();

    @Override
    public void cadastroDeCurso(Curso curso) {
        cursoRepository.cadastroCurso(curso);
        System.out.println("======================\u001B[32mCurso cadastrado com sucesso!\u001B[0m======================");
    }

    @Override
    public void atualizarCurso(int codigo, String nome, int quantidadeAluno, List<Pessoa> pessoas) {
        List<Curso> cursoList = cursoRepository.listarCursosRepositorio();

        for (Curso curso : cursoList) {
            if (curso.getCodigo() == codigo) {
                curso.setNome(nome);
                curso.setTotalAlunos(quantidadeAluno);
                curso.setPessoaList(pessoas);
                System.out.println("======================\u001B[32mCurso atualizado com sucesso!\u001B[0m======================");
                return;
            }
        }
        System.out.println("======================\u001B[31mCurso não encontrada!\u001B[0m======================");
    }

    @Override
    public void excluirCurso(int codigo) {
        List<Curso> cursoList = cursoRepository.listarCursosRepositorio();
        ListIterator<Curso> cursoInterator = cursoList.listIterator(cursoList.size());

        while (cursoInterator.hasPrevious()) {
            Curso curso = cursoInterator.previous();
            if (curso.getCodigo() == codigo) {
                cursoInterator.remove();
                System.out.println("======================\\u001B[32mCurso excluído com sucesso!\\u001B[0m======================");
                return;
            }
        }
        System.out.println("======================\u001B[31mCurso não encontradao\u001B[0m======================");
    }

    @Override
    public List<Curso> listarCurso() {
        List<Curso> cursoList = cursoRepository.listarCursosRepositorio();

        for (Curso curso : cursoList) {
            System.out.println("\u001B[32m\nCódigo: " + curso.getCodigo()
                    + "\nNome do curso: " + curso.getNome()
                    + "\nTotal de alunos: " + curso.getTotalAlunos()
                    + "\nHorario de inicio: " + curso.getHorarioInicio()
                    + "\nHorario de encerramento: " + curso.getHorarioFinal()
                    + "\nPessoas associadas ao curso: ");

            List<Pessoa> pessoaCursoList = listarPessoaDoCurso(curso.getCodigo());
            for (Pessoa pessoa : pessoaCursoList) {
                String tipoPessoa = "Desconhecido";

                // Verificar o tipo de pessoa (pode variar dependendo da sua implementação)
                if (pessoa instanceof Aluno) {
                    tipoPessoa = "Aluno";
                } else if (pessoa instanceof Professor) {
                    tipoPessoa = "Professor";
                }

                System.out.println("\tCódigo: " + pessoa.getCodigo() + "\tNome: " + pessoa.getNome() + "\tTipo: " + tipoPessoa);
            }

            System.out.println("\n\u001B[0m");
        }
        return cursoList;
    }

    public List<Pessoa> listarPessoaDoCurso(int codigoCurso) {
        List<Pessoa> pessoasAssociadas = new ArrayList<>();
        List<Pessoa> pessoaList = cursoRepository.listarPessoasAssociadasAoCurso(codigoCurso);

        for (Pessoa pessoa : pessoaList) {
            pessoasAssociadas.add(pessoa);
        }

        return pessoasAssociadas;
    }


    @Override
    public Curso buscarCursoPorCodigo(int codigo) {
        List<Curso> cursos = cursoRepository.listarCursosRepositorio();
        for (Curso curso : cursos) {
            if (curso.getCodigo() == codigo) {
                return curso;
            }
        }
        return null;
    }

    @Override
    public void vincularPessoasAoCurso(Pessoa pessoa, int totalAlunos, int codigo) {
        List<Pessoa> listPessoa = PessoaRepository.listPessoa;
        List<Pessoa> pessoaList = cursoRepository.listarPessoasAssociadasAoCurso(codigo);

        if (listPessoa.contains(pessoa)) {
            if (!pessoaList.contains(pessoa)) {
                if (pessoaList.size() < totalAlunos) {
                    cursoRepository.vincularAlunoAoCurso(pessoa);
                    System.out.println("Pessoa adicionada ao curso " + pessoa.getNome() + " com sucesso!");
                } else {
                    System.out.println("Capacidade máxima de alunos atingida no curso " + pessoa.getNome() + ".");
                }
            } else {
                System.out.println("A pessoa já está vinculada ao curso " + pessoa.getNome() + ".");
            }
        } else {
            System.out.println("Pessoa não encontrada na lista geral.");
        }
    }
}
