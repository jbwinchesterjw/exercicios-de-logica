package atividadesenai;

import java.util.Arrays;
import java.util.Scanner;

public class CadastroPessoa2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nome;
        int idade;
        System.out.println("qantidade");
        int qt = input.nextInt();
        String listaNomes[] = new String[qt];
        int[] listaIdade = new int[qt];
        int i = -1;
        int loop = 1;
        while (loop == 1) {
            System.out.println("1 adiciona");
            System.out.println("2 excluir");
            System.out.println("3 sair");
            System.out.println("4 litar cadastro");

            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Nome:");
                    nome = input.next();
                    System.out.println("Idade:");
                    idade = input.nextInt();
                    if ((i < listaNomes.length - 1) || (listaNomes[i] == null) || (i < listaIdade.length - 1)) {
                        i = i + 1;
                        listaNomes[i] = nome;
                        listaIdade[i] = idade;

                    } else {
                        System.out.println("Lista Cheia, nome :" + nome + " não adicionado !");
                        System.out.println("Sua lista " + Arrays.deepToString(listaNomes));
                    }
                    break;
                case 2:
                    System.out.println("nome para excluir");
                    nome = input.next();
                    for (int j = 0; j < listaNomes.length; j++) {
                        if (listaNomes[j].equals(nome)) {
                            listaNomes[j] = null;
                            System.out.println("Lista " + Arrays.deepToString(listaNomes));
                        }
                    }
                    break;
                case 3:
                    System.out.println("Programa finalizado !");
                    loop++;
                case 4:
                    System.out.println("Lista de nomes " + Arrays.deepToString(listaNomes));
                    break;
            }

        }
    }

}
