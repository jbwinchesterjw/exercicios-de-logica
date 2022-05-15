import java.util.Locale;
import java.util.Scanner;

public class Vetor {
    /**
     * variavel composta ou seja pode armazenar varios elementos em um unica variavel
     * deve ser usada quando necessita ter varias variavel do mesmo valor
     * vetor dimencional [3] vai ser igual a 4 casas em linha reta
     * colocar em ordem Arrays.sort(vetor)
     * Object[] data = {"Kiwi","Banana","Mango","Aubergine","Strawberry"};
     * List list = Arrays.asList(data);
     * Collections.sort(list);
     * System.out.println(list);
     * @param args
     */
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        ent.useLocale(Locale.US);
        int n, m, i, j;;
        System.out.println("numero de alunos");
        n = ent.nextInt(); // numero de alunos
        System.out.println("numero de disciplinas");
        m = ent.nextInt(); // numero de disciplinas
        String [] a = new String[n]; // nomes dos alunos
        String [] d = new String[m]; // nomes das disciplinas
        double [][] M = new double[n][m]; // notas
        // nomes dos alunos
        for (i=0; i<n; i++) {
            a[i] = ent.nextLine();
        }
        // nomes das disciplinas
        for (j=0; j<m; j++) {
            d[i] = ent.nextLine();
        }
        // monta tabela de notas: alunos X disciplinas
        for (i=0; i<n; i++) {
            for (j=0; j<m; j++) {
                M[i][j] = ent.nextDouble();
            }
        }
        // calcula a nota média de cada disciplina
        double soma=0, media=0;
        for (j=0; j<m; j++) {
            for (i=0; i<n; i++) {
                soma = soma + M[i][j];
            }
            media = soma/n;
            System.out.println("Média de "+d[j]+": "+media);
        }

        //int n = 5; // tamanho do vetor
        //int v[] = new int[n]; // declaração do vetor "v"
        //int i; // índice ou posição

        //String [][][] ve = new String[1][1][1];

        //System.out.println(ve);

        /*// Entrada de Dados
        for (i = 0; i < n; i++) {
            System.out.printf("Informe %2do. valor de %d: ", (i + 1), n);
            v[i] = ler.nextInt();
        }

        // Processamento: somar todos os valores, definir o maior e o menor valor
        int soma = 0;
        int menor = v[0]; // v[0] = 1o. valor armazenador no vetor "v"
        int maior = v[0];
        for (i = 0; i < n; i++) {
            soma = soma + v[i];

            if (v[i] < menor)
                menor = v[i];

            if (v[i] > maior)
                maior = v[i];
        }
        // Saída (resultados)
        System.out.printf("\n");
        for (i = 0; i < n; i++) {
            if (v[i] == menor)
                System.out.printf("v[%d] = %2d <--- menor valor\n", i, v[i]);
            else if (v[i] == maior)
                System.out.printf("v[%d] = %2d <--- maior valor\n", i, v[i]);
            else System.out.printf("v[%d] = %2d\n", i, v[i]);
        }

        System.out.printf("\nSoma = %d\n", soma);*/
    }
}
