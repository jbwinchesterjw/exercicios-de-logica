package polimofismo.pessoa.impl;


import polimofismo.aluno.Aluno;
import polimofismo.curso.Curso;
import polimofismo.curso.repository.CursoRepository;
import polimofismo.pessoa.Pessoa;
import polimofismo.pessoa.PessoaInterface;
import polimofismo.pessoa.repository.PessoaRepository;
import polimofismo.professor.Professor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaImplementacao implements PessoaInterface {

    PessoaRepository pessoaRepository = new PessoaRepository();
    CursoRepository cursoRepository = new CursoRepository();


    @Override
    public void cadastrarPessoa(Pessoa pessoa) {
        pessoaRepository.cadastraPessoaRepositorio(pessoa);
        System.out.println("======================\u001B[32mPessoa Cadastrado com sucesso!\u001B[0m======================");
    }

    @Override
    public void atualizarPessoa(int codigoPessoa, String novoEmail, String novoNome, LocalDate novaDataNascimento) {
        List<Pessoa> pessoaList = pessoaRepository.listarPessoaRepositorio();

        for (Pessoa pessoa : pessoaList) {
            if (pessoa.getCodigo() == codigoPessoa) {
                pessoa.setEmail(novoEmail);
                pessoa.setNome(novoNome);
                pessoa.setDatanascimento(novaDataNascimento);
                System.out.println("======================\u001B[32mPessoa atualizada com sucesso!\u001B[0m======================");
                return;
            }
        }

        System.out.println("======================\u001B[31mPessoa não encontrada!\u001B[0m======================");
    }

    @Override
    public void excluirPessoa(int codigo) {
        List<Pessoa> pessoaList = pessoaRepository.listarPessoaRepositorio();
        List<Curso> cursoList = cursoRepository.listarCursosRepositorio();

        boolean pessoaAssociadaACurso = cursoList.stream()
                .anyMatch(curso -> curso.getPessoaList().stream()
                        .anyMatch(pessoa -> pessoa.getCodigo() == codigo));

        if (!pessoaAssociadaACurso) {
            pessoaList.removeIf(pessoa -> pessoa.getCodigo() == codigo);
            System.out.println("======================\u001B[32mPessoa excluída com sucesso!\u001B[0m======================");
        } else {
            System.out.println("======================\u001B[31mA pessoa está associada a um curso. Não pode ser excluída!\u001B[0m======================");
        }
    }

    @Override
    public List<Pessoa> listarPessoa() {
        List<Pessoa> pessoaList = pessoaRepository.listarPessoaRepositorio();

        for (Pessoa pessoa : pessoaList) {
            System.out.println("\n" +
                    (pessoa instanceof Aluno ? "Aluno" : "Professor") + "\n" +
                    "Código: " + pessoa.getCodigo() +
                    "\nNome: " + pessoa.getNome() +
                    "\nE-mail: " + pessoa.getEmail() +
                    "\nData Nascimento: " + pessoa.getDatanascimento() +
                    "\nEndereço: " + pessoa.getEndereco());
        }
        return pessoaList;
    }

    public void listarAlunos() {
        List<Pessoa> pessoaList = pessoaRepository.listarPessoaRepositorio();

        for (Pessoa pessoa : pessoaList) {
            if (pessoa instanceof Aluno) {
                System.out.println("\nAluno\n" +
                        "Código: " + ((Aluno) pessoa).getCodigo() +
                        "\nNome: " + pessoa.getNome() +
                        "\nE-mail: " + pessoa.getEmail() +
                        "\nData Nascimento: " + pessoa.getDatanascimento() +
                        "\nEndereço: " + pessoa.getEndereco());

            }

        }
    }

    public void listarProfessores() {
        List<Pessoa> pessoaList = pessoaRepository.listarPessoaRepositorio();

        for (Pessoa pessoa : pessoaList) {
            if (pessoa instanceof Professor) {
                System.out.println("\nProfessor\n" +
                        "Código: " + ((Professor) pessoa).getCodigo() +
                        "\nNome: " + pessoa.getNome() +
                        "\nE-mail: " + pessoa.getEmail() +
                        "\nData Nascimento: " + pessoa.getDatanascimento() +
                        "\nEndereço: " + pessoa.getEndereco());
            }
        }

    }

    @Override
    public Pessoa buscarPessoaPorCadigo(int codigo) {
        List<Pessoa> pessoaList = pessoaRepository.listarPessoaRepositorio();
        for (Pessoa pessoa : pessoaList) {
            if (pessoa.getCodigo() == codigo) {
                return pessoa;
            }
        }
        return null;
    }

    public void verificarEmail(String email) {
        List<Pessoa> pessoaList = pessoaRepository.listarPessoaRepositorio();
        for (Pessoa pessoa : pessoaList) {
            if (pessoa.getEmail().equals(email)) {
                System.out.println("Já existe uma pessoa com o email informado!");
            }
        }
    }
}
