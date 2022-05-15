package atividadesenai.pilha_situacao1_5;

public class PilhaMan {
    public static void main(String[] args) {
        String[] arrayNamesDaPilha = {
                "Test1", "Test2", "Test3", "Test4", "Test5", "Test6",
                "Test7", "Test8", "Test9", "Test10", "Test11", "Test12",
                "Test13", "Test14", "Test15", "Test16", "Test17", "Test18",
                "Test19", "Test20"
        };
        Pilha pilha = new Pilha(20);

        System.out.println(
                "Pilha de " + pilha.getCapacidade_pilha() + " posições criada: " + pilha
        );
        System.out.println();

        System.out.println("Preenchendo a pilha:");
        for(int i = 0; i < arrayNamesDaPilha.length; i++) {
            System.out.print("\tInserindo o nome \"" + arrayNamesDaPilha[i] + "\":\t");
            if(pilha.push(arrayNamesDaPilha[i]) == null)
                System.out.println("PILHA CHEIA!!! impossível adicionar mas elementos...");
            else
                System.out.println(
                        pilha + ". " + (pilha.getCapacidade_pilha() - pilha.getSize()) +
                                " posições restantes."
                );
        }
        System.out.println();

        System.out.println("Removendo 10 elementos da pilha:");
        for(int i = 1; i <= 10; i++) {
            System.out.print("\t" + i + "a. remoção: \"" + pilha.pop() + "\".");
            System.out.println(" A pilha agora esta assim: " + pilha);
        }
        System.out.println("Nome no topo da pilha é \"" + pilha.top() + "\".");
        System.out.println("Pilha" + pilha);
        pilha.clear_pilha();
        System.out.println("Limpando todos elementos da pilha: " + pilha);
        System.out.println();
    }
}
