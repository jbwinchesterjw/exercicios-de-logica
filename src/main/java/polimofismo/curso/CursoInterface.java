package polimofismo.curso;


import polimofismo.pessoa.Pessoa;

import java.util.List;

public interface CursoInterface {

    void cadastroDeCurso(Curso curso);

    void atualizarCurso(int codigo, String nome, int quantidadeAluno, List<Pessoa> pessoas);

    void excluirCurso(int codigo);

    List<Curso> listarCurso();

    Curso buscarCursoPorCodigo(int codigo);

    void vincularPessoasAoCurso(Pessoa pessoa, int totalAlunos, int codigo);
}
