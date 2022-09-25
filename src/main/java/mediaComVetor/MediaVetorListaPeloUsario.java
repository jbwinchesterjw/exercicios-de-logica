package mediaComVetor;

import java.util.Scanner;

public class MediaVetorListaPeloUsario {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       

        System.out.println("Informe o aluno(a) tem na sala de aula!");
        int quantidadeDeAlunos = input.nextInt();

        String nomeAlunos [] = new String[quantidadeDeAlunos];
        double mediaAluo [] = new double[quantidadeDeAlunos];
        double notaAlunos [][] = new double[quantidadeDeAlunos][4];


        for (int i = 0; i < quantidadeDeAlunos; i++){
            System.out.println("Aluno "+(i+1)+" °");
            nomeAlunos[i] = input.next();
        }

        for (int i = 0; i < quantidadeDeAlunos; i++) {
            for (int j = 0; j< 4; j++){
                notaAlunos[i][j] = input.nextDouble(); 
            }
        }
        
        
        

    }
}
