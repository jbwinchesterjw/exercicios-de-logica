package atividadesenai.pilha_situacao1_5;

public class Pilha {

    private int size;
    private String[] capacidadeArmazenamentoPilha;

    /**
     * recebe um int como parâmetro, indicando qual será a capacidade de armazenamento da pilha.
     *
     * @param capacidade
     */
    public Pilha(int capacidade) {
        capacidadeArmazenamentoPilha = new String[Math.abs(capacidade)];
        size = 0;
    }

    /**
     * Remove o elemento do topo da pilha
     *
     * @return
     */
    public String pop() {
        String result = top();
        if (result != null) {
            capacidadeArmazenamentoPilha[getTopPosicao()] = null;
            size--;
        }
        return result;
    }

    /**
     * Método para se obter o elemento que está no topo desta pilha.
     *
     * @return
     */
    public String top() {
        if (isEmpty())
            return null;
        return capacidadeArmazenamentoPilha[getTopPosicao()];
    }

    /**
     * adiciona um nono elemento na pilha.
     *
     * @param elemento
     * @return
     */
    public String push(String elemento) {
        if (elemento == null)
            throw new IllegalArgumentException("O elemento não pode ser nulo!");

        if (size == capacidadeArmazenamentoPilha.length)
            return null;
        size++;
        capacidadeArmazenamentoPilha[getTopPosicao()] = elemento;
        return elemento;
    }

    /**
     * Método utilizado para limpar todo o conteúdo da pilha.
     */
    public void clear_pilha() {
        for (int i = 0; i < size; i++)
            capacidadeArmazenamentoPilha[i] = null;
        size = 0;
    }

    /**
     * Método para se obter o número de elementos da pilha.
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Método para se obter a capacidade da pilha.
     *
     * @return
     */
    public int getCapacidade_pilha() {
        return capacidadeArmazenamentoPilha.length;
    }

    /**
     * Método para verificar se a pilha está vazia. Se for o caso,
     *
     * @return caso vazio return true, do cotrario false.
     */
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     * Método para retornar a posição do elemento na pilha.
     *
     * @return
     */
    private int getTopPosicao() {
        if (isEmpty())
            return 0;
        return size - 1;
    }

    /**
     * Método apenas para textualizar a pilha.
     *
     * @return
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[-");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(capacidadeArmazenamentoPilha[i]);
            if (i < size - 1)
                stringBuilder.append(" | ");
        }
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}
