import javax.swing.*;
import java.util.Arrays;

public class ControleBolvino1 {
    /**
     * Em uma fazenda os gados são marcados com números inteiros. O fazendeiro em questão possui uma quantidade de 42 gados e
     * precisa fazer uma separação em dois campos de pastagens distintos. Para isso ele decidiu colocar os gados com marcação de
     * números pares no pasto de número 1 e gados com números impares no pasto 2. Você com ideia de automatizar essa separação e
     * propôs a criação de um algoritmo que faz a leitura dos números dos 42 gados e separa por ímpar ou par em dois vetores distintos,
     * após a leitura mostre na tela os dois vetores, pois eles que indicarão qual gado deverá ir para qual pasto.
     * <p>
     * Regras:
     * 1 - O algoritmo poderá considerar que o usuário não irá repetir o número do gado na leitura.
     * 2 - Os vetores devem armazenar os números de forma sequencial, ou seja não poderá pular posições em seu armazenamento.
     */
    public static void main(String[] args) {
        int TAMVET = Integer.parseInt(JOptionPane.showInputDialog("Porfavor, Informe quantos cadastros serão feitos"));
        int lista[] = new int[TAMVET];
        String m = "";
        boolean repetiu = false;

        Arrays.sort(lista); // ordenar o vetor

        m += ("-----------~~'OS Valores Repetidos'~~--------------  \n");
        int last = lista.length;
        for (int i = 0; i < TAMVET; i++) {
            lista[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o Numero da " + (i) + "º Posição do Vetor"));
            for (i = 1; i < lista.length; i++) {
                if (lista[i] == lista[i - 1] && last != lista[i - 1]) {
                    last = lista[i];
                    System.out.println("Numero repetido : " + last + " informe outro");
                }
            }
        }
        for (int i = 1; i < lista.length; i++) {
            if (lista[i] == lista[i - 1] && last != lista[i - 1]) {
                System.out.println("Esse numero ja foi cadastrado !");
                repetiu = true;
                last = lista[i];
                System.out.println("O Numero: " + last + " Se Repete no Vetor");
            }
        }
        if (!repetiu) {
            m += ("                 ~~'Nenhum Elemento Foi Repetido'~~");
        }
        JOptionPane.showMessageDialog(null, m); // mostra na janela a variavel m.
    }


//        public static void main(String[] args) {
//
//            ControleBolvino teste = new ControleBolvino();
//            teste.adicionaNumeroRandomico();
//        }
//
//        private void adicionaNumeroRandomico() {
//
//            while (lista.size() < 6) {
//                lista.add(geraNumeroAleatorio());
//            }
//
//            imprimir();
//        }
//
//        private void imprimir() {
//
//            for (Integer numeroRandomico : lista) {
//                System.out.println(numeroRandomico);
//            }
//
//        }
//
//        private int geraNumeroAleatorio() {
//            return (int) (Math.random() * 10);
//        }

}

