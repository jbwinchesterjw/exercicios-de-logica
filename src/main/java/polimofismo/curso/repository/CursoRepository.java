package polimofismo.curso.repository;


import polimofismo.curso.Curso;
import polimofismo.pessoa.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CursoRepository {

    List<Curso> cursoList = new ArrayList<>();
    List<Pessoa> pessoaList = new ArrayList<>();

    public void cadastroCurso(Curso curso) {
        cursoList.add(curso);
    }

    public List<Curso> listarCursosRepositorio() {
        return cursoList;
    }

    public void vincularAlunoAoCurso(Pessoa aluno) {
        pessoaList.add(aluno);
    }

    public List<Pessoa> listarPessoasAssociadasAoCurso(int codigo) {
        return pessoaList.stream().filter(pessoa -> pessoa.getCodigo() == codigo).collect(Collectors.toList());
    }
}
