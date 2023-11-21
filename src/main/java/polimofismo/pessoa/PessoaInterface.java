package polimofismo.pessoa;

import java.time.LocalDate;
import java.util.List;

public interface PessoaInterface {

    void cadastrarPessoa(Pessoa pessoa);

    void atualizarPessoa(int codigoPessoa, String novoEmail, String novoNome, LocalDate novaDataNascimento);

    void excluirPessoa(int codigo);

    void listarPessoa();

    Boolean buscarPessoaPorCadigo(int codigo);

    List<Pessoa> listarProfessores();

    List<Pessoa> listarAlunos();
}
