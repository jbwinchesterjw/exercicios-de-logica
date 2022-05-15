package senaiEtapa2_1;

public class NovoArray {
        protected int[]a;
        int indice=0;

        NovoArray(int tamanho){
            a = new int[tamanho];
        }


        public int getIndice(){
            return indice;
        }

        public void addItem(int numero){
            if(getIndice()<a.length){
                a[getIndice()] = (int)(numero);
                indice++;
            }
            else{
                System.out.println("Array esta cheio e não podem ser adicionados mais itens!");
            }
        }

        public void removeItem(){
            indice=indice-1;
        }

        public boolean getListaCheia(){
            if(getIndice()>a.length){
                return true;
            }
            else{
                return false;
            }
        }

        public int mostraMaior(){
            int maior=a[0];
            for (int i=0; i<a.length;i++)
                if (maior<a[i])
                    maior=a[i];
            return maior;
        }

        public int mostraMenor(){
            int menor=a[0];
            for (int i=0; i<a.length;i++)
                if (menor>a[i])
                    menor=a[i];
            return menor;
        }

        public int mostraUltimo(){
            return a[getIndice()];
        }

        public int getTamanho(){
            return (int)(a.length);
        }

        public int getValor(int posicao){
            return a[posicao];

        }

        public void procuraElemento(int elemento){
            for (int i=0; i<getTamanho();  i++)
                if(getValor(i)==elemento){
                    System.out.println("existe");
                }
                else{
                    System.out.println("nao existe");
                }
        }
}
