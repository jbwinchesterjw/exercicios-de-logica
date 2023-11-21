package polimofismo.curso;


import polimofismo.pessoa.Pessoa;

import java.util.List;

public class Curso {
    private static int codigoGerado = 1;
    private int codigo;
    private String nome;
    private int totalAlunos;
    private List<Pessoa> pessoaList;

    public Curso(String nome, int totalAlunos, List<Pessoa> pessoaList) {
        this.codigo = codigoGerado++;
        this.nome = nome;
        this.totalAlunos = totalAlunos;
        this.pessoaList = pessoaList;
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

}
