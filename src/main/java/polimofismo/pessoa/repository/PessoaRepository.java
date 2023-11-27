package polimofismo.pessoa.repository;


import polimofismo.pessoa.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {

    public static List<Pessoa> listPessoa = new ArrayList<>();

    public void cadastraPessoaRepositorio(Pessoa pessoa){
        listPessoa.add(pessoa);
    }

    public List<Pessoa> listarPessoaRepositorio(){
        return listPessoa;
    }
}
