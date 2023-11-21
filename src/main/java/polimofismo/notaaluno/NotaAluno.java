package polimofismo.notaaluno;


import polimofismo.curso.Curso;

import java.util.List;

public class NotaAluno {
    private List<Double> notasDoAlunos;
    private Curso curso;

    public List<Double> getNotasDoAlunos() {
        return notasDoAlunos;
    }

    public void setNotasDoAlunos(List<Double> notasDoAlunos) {
        this.notasDoAlunos = notasDoAlunos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
