package FilaDoRecreio;

import Filas.FilaMaiorO;
import Listas.ListaEstatica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int qtdCasos;
        int numEstudantes;
        int nota;
        int fixos;

        FilaMaiorO<Integer> fila;
        ListaEstatica<Integer> original;

        qtdCasos = dado.nextInt();

        for(int i = 0; i < qtdCasos; i++) {
            fixos = 0;
            fila = new FilaMaiorO();
            original = new ListaEstatica<>();
            numEstudantes = dado.nextInt();

            for(int j = 0; j < numEstudantes; j++) {
                nota = Integer.parseInt(dado.next());
                fila.enqueue(nota,nota);
                original.add(nota);
            }

            for(int j = 0; j < numEstudantes; j++) {
                if(fila.peek().equals(original.get(j))) {
                    fixos++;
                }
                fila.dequeue();
            }

            System.out.println(fixos);
        }
    }
}