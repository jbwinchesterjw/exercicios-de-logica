import java.util.ArrayList;
import java.util.List;

public class RedeDeConexoes {
    private int totalDeMembros;
    private List<List<Integer>> conexoes;

    /**
     * Construtor personalizado executado a cada nova criação de RedeDeConexões.
     *
     * @param totalDeMembros Total de membros para a rede.
     * @throws IllegalArgumentException se o número de elementos for menor ou igual a zero.
     */
    public RedeDeConexoes(int totalDeMembros) {
        if (totalDeMembros <= 0) {
            throw new IllegalArgumentException("O número de elementos deve ser positivo!");
        }
        this.totalDeMembros = totalDeMembros;
        this.conexoes = new ArrayList<>(totalDeMembros);
        for (int i = 0; i < totalDeMembros; i++) {
            this.conexoes.add(new ArrayList<>());
        }
    }

    /**
     * Adiciona uma nova conexão entre membros à rede.
     *
     * @param membro1 Membro a ser adicionado.
     * @param membro2 Membro a ser adicionado.
     * @throws IllegalArgumentException se algum dos membros for inválido.
     */
    public void conexao(int membro1, int membro2) {
        if (!validarElemento(membro1) || !validarElemento(membro2)) {
            throw new IllegalArgumentException("elemento inválido");
        }
        conexoes.get(membro1).add(membro2);
        conexoes.get(membro2).add(membro1);
    }

    /**
     * Verifica se os dois membros adicionados estão conectados na rede.
     *
     * @param membro1 Membro 01.
     * @param membro2 Membro 02.
     * @return Retornar verdadeiro se os elementos estiverem conectados.
     * @throws IllegalArgumentException se algum dos membros for inválido.
     */
    public boolean consultar(int membro1, int membro2) {
        if (!validarElemento(membro1) || !validarElemento(membro2)) {
            throw new IllegalArgumentException("elemento inválido");
        }
        boolean[] visited = new boolean[totalDeMembros];
        return buscaConexao(membro1, membro2, visited);
    }

    /**
     * Verifica se dois membros estão conectados na rede.
     *
     * @param membroInicial Membro inicial da busca.
     * @param membroDaBusca Membro de destino que estamos procurando.
     * @param membroVisitado Array que armazena se um membro já foi visitado ou não.
     * @return true se os membros estiverem conectados, false caso contrário.
     */
    private boolean buscaConexao(int membroInicial, int membroDaBusca, boolean[] membroVisitado) {
        if (membroInicial == membroDaBusca) {
            return true;
        }
        membroVisitado[membroInicial] = true;
        for (int vizinho : conexoes.get(membroInicial)) {
            if (!membroVisitado[vizinho] && buscaConexao(vizinho, membroDaBusca, membroVisitado)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se o membro passado por parâmentro e valido.
     *
     * @param membro a ser verificado.
     * @return True ou false de acordo com a validação feita.
     */
    private boolean validarElemento(int membro) {
        return membro >= 0 && membro < totalDeMembros;
    }

    public static void main(String[] args) {
        RedeDeConexoes redeConexoes = new RedeDeConexoes(8);
        redeConexoes.conexao(1, 2);
        redeConexoes.conexao(6, 2);
        redeConexoes.conexao(2, 4);
        redeConexoes.conexao(5, 8);

        try {
            System.out.println(redeConexoes.consultar(1, 6));  // true
            System.out.println(redeConexoes.consultar(6, 4));  // true
            System.out.println(redeConexoes.consultar(7, 4));  // false
            System.out.println(redeConexoes.consultar(5, 6));  // false
            System.out.println(redeConexoes.consultar(1, 2));  // true
            System.out.println(redeConexoes.consultar(1, 8));  // false
        } catch (IllegalArgumentException e) {
            System.out.println("Consulta inválida: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
