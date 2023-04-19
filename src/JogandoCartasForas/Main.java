package JogandoCartasForas;

import Filas.FilaDinamica;
import Filas.FilaPrioridadeO;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        FilaPrioridadeO<Integer> filaInicial;
        FilaDinamica<Integer> filaDescarte;
        int qtdCartas;
        int aux;

        for(qtdCartas = dado.nextInt(); qtdCartas != 0; qtdCartas = dado.nextInt()) {
            filaInicial = new FilaPrioridadeO<>();
            filaDescarte = new FilaDinamica<>();

            for(int i = 0; i < qtdCartas; i++) {
                filaInicial.enqueue(i+1,i+1);
            }

            while(filaInicial.size() > 1) {
                aux = filaInicial.dequeue();
                filaDescarte.enqueue(aux);
                aux = filaInicial.dequeue();
                qtdCartas+=1;
                filaInicial.enqueue(aux, qtdCartas);
            }

            System.out.println("Dicarted cards: "+filaDescarte);
            System.out.println("Remaining card: "+filaInicial);
        }
    }
}