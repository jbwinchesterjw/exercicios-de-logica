package polimofismo.professor;


import polimofismo.pessoa.Pessoa;

import java.time.LocalDate;

public class Professor extends Pessoa {
    private Double salario;

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Professor(String nome, String email, LocalDate dataNascimento) {
        super(nome, email, dataNascimento);
    }

}
