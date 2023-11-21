package polimofismo.pessoa;

import java.time.LocalDate;

public class Pessoa {
    private static int codigoGerado = 1;
    private int codigo;
    private String nome;
    private String email;
    private LocalDate datanascimento;
    private String endereco;

    public Pessoa(String nome, String email, LocalDate dataNascimento) {
        this.codigo = codigoGerado++;
        this.nome = nome;
        this.email = email;
        this.datanascimento = dataNascimento;
    }

    public static int getCodigoGerado() {
        return codigoGerado;
    }

    public static void setCodigoGerado(int codigoGerado) {
        Pessoa.codigoGerado = codigoGerado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public LocalDate getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }
}
