package polimofismo.curso;


import polimofismo.pessoa.Pessoa;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Curso {
    private static int codigoGerado = 1;
    private int codigo;
    private String nome;
    private int totalAlunos;
    private List<Pessoa> pessoaList;
    private LocalTime horarioInicio;
    private LocalTime horarioFinal;

    public Curso(String nome, int totalAlunos, List<Pessoa> pessoaList, LocalTime horarioInicio, LocalTime horarioFinal) {
        this.codigo = codigoGerado++;
        this.nome = nome;
        this.totalAlunos = totalAlunos;
        this.pessoaList = pessoaList;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static int getCodigoGerado() {
        return codigoGerado;
    }

    public static void setCodigoGerado(int codigoGerado) {
        Curso.codigoGerado = codigoGerado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(int totalAlunos) {
        this.totalAlunos = totalAlunos;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(LocalTime horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

}
