package polimofismo.aluno;


import polimofismo.pessoa.Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

    private List<Double> notasDoAluno;

    public List<Double> getNotasDoAluno() {
        return notasDoAluno;
    }

    public void setNotasDoAluno(List<Double> notasDoAluno) {
        this.notasDoAluno = notasDoAluno;
    }

    public Aluno(String nome, String email, LocalDate dataNascimento) {
        super(email, nome, dataNascimento);
    }

    private static List<Aluno> listaDeAlunos = new ArrayList<>();

    public static List<Aluno> getAlunos() {
        return listaDeAlunos;
    }

}
