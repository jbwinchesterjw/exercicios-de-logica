package mediaComVetor;

import java.util.Scanner;

public class MediaComVetorListaPronta {
    public static void main(String[] args) {
/**
 *  Vetor - (array uni-dimensional) é uma variável que armazena várias variáveis do mesmo tipo.
 *  
 *  Matriz - (array multi-dimensional) é um vetor de vetores. No nosso problema, 
 *  imagine uma matriz para armazenar as 4 notas de cada um dos 50 alunos. Ou seja, 
 *  um vetor de 50 posições, e em cada posição do vetor, há outro vetor com 4 posições. Isso é uma matriz.
 */
        final int TOTAL_ALUNOS = 4;
        final int TOTAL_BIMESTRES = 4;
        final double NOTA_MINIMA = 7.0;

        Scanner input = new Scanner(System.in);
        String[] nomeAlunos = new String[TOTAL_ALUNOS];
        double[][] notaAlunos = new double[TOTAL_ALUNOS][TOTAL_BIMESTRES];
        double[] mediaAlunos = new double[TOTAL_ALUNOS];

        //Obter nome dos alunos
        for(int i = 0; i < TOTAL_ALUNOS; ++i){
            System.out.println("Informe o nome do " + (i+1) + "° aluno:");
            nomeAlunos[i] = input.nextLine();
        }

        System.out.println("");

        //Obter notas dos alunos todos os bimetres
        for(int i = 0; i < TOTAL_ALUNOS; ++i){
            for(int j = 0; j < TOTAL_BIMESTRES; ++j){
                System.out.println("Informe a nota do aluno " + nomeAlunos[i] +
                        " para o " + (j+1) + "° bimestre");
                notaAlunos[i][j] = input.nextDouble();
            }
        }

        //calcular media alunos
        for(int i = 0; i < TOTAL_ALUNOS; ++i){
            for(int j = 0; j < TOTAL_BIMESTRES; ++j){
                mediaAlunos[i] += notaAlunos[i][j];
            }
            mediaAlunos[i] /= TOTAL_BIMESTRES;
        }

        //Mostrar situacao dos alunos
        System.out.println("======== RESULTADO FINAL =======");

        for(int i = 0; i < TOTAL_ALUNOS; ++i){

            if(mediaAlunos[i] >= NOTA_MINIMA ){
                System.out.println("Nome: " + nomeAlunos[i] + " Media: " + mediaAlunos[i] +
                        " Situação: Aprovado");
                continue;
            }

            System.out.println("Nome: " + nomeAlunos[i] + " Media: " + mediaAlunos[i] +
                    " Situação: Reprovado");
        }

    }
    
}
