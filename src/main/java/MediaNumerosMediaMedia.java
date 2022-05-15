public class MediaNumerosMediaMedia {
    /**
     * Fazer um programa que imprima a média aritmética dos números 8,9 e 7.
     * A média dos números 4, 5 e 6. A soma das duas médias. A média das médias.
     */
    public static void main(String [] args){
        int n1 = 7;
        int n2 = 8;
        int n3 = 9;
        int n4 = 4;
        int n5 = 5;
        int n6 = 6;
        double mediaNumero1, mediaNumero2, mediaDaMedia;

        mediaNumero1 = (n1 + n2 + n3) / 3;
        mediaNumero2 = (n4 + n5+ n6) / 3;
        mediaDaMedia = (mediaNumero1 + mediaNumero2) / 2;
        System.out.println("Media dos primerios numero ="+ mediaNumero1);
        System.out.println("Media dos primerios numero ="+ mediaNumero2);
        System.out.println("Media dos primerios numero ="+ mediaDaMedia);
    }
}
