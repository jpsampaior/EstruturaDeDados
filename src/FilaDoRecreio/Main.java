package FilaDoRecreio;

import Filas.FilaMaiorONumTrocas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int qtdCasos;
        int numEstudantes;
        int nota;
        FilaMaiorONumTrocas<Integer> fila;

        qtdCasos = dado.nextInt();

        for(int i = 0; i < qtdCasos; i++) {
            fila = new FilaMaiorONumTrocas();
            numEstudantes = dado.nextInt();

            for(int j = 0; j < numEstudantes; j++) {
                nota = Integer.parseInt(dado.next());
                fila.enqueue(nota,nota);
            }

            System.out.println(fila.getTrocas());
        }
    }
}