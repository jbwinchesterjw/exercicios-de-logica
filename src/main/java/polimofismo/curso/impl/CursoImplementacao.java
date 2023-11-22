package polimofismo.curso.impl;


import polimofismo.curso.Curso;
import polimofismo.curso.CursoInterface;
import polimofismo.curso.repository.CursoRepository;
import polimofismo.pessoa.Pessoa;
import polimofismo.pessoa.PessoaInterface;
import polimofismo.pessoa.impl.PessoaImplementacao;

import java.util.List;
import java.util.ListIterator;

public class CursoImplementacao implements CursoInterface {

    CursoRepository cursoRepository = new CursoRepository();
    static PessoaInterface pessoaInterface = new PessoaImplementacao();

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
    public void listarCurso() {
        List<Curso> cursoList = cursoRepository.listarCursosRepositorio();
        for (Curso curso : cursoList) {
            System.out.println("\u001B[32m\nCódigo: " + curso.getCodigo()
                    + "\nNome: " + curso.getNome()
                    + "\nTotal de alunos: " + curso.getTotalAlunos()
                    + "\nPessoas associadas ao cuso: "
                    + curso.getPessoaList() + "\n\u001B[0m");
        }

    }

    @Override
    public Boolean buscarCursoPorCodigo(int codigo) {
        List<Curso> cursos = cursoRepository.listarCursosRepositorio();
        for (Curso curso : cursos) {
            if (curso.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void vincularPessoasAoCurso(int codigoAluno) {

    }
}
