package FilaExercicioBeecrowd;

import Filas.FilaDesistencia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        FilaDesistencia fila = new FilaDesistencia();
        int qtdPessoas;
        int id;

        qtdPessoas = dado.nextInt();

        for(int j = 0; j < qtdPessoas; j++) {
            id = Integer.parseInt(dado.next());
            fila.enqueue(id);
        }

        qtdPessoas = dado.nextInt();

        for(int j = 0; j < qtdPessoas; j++) {
            id = Integer.parseInt(dado.next());
            fila.dequeue(id);
        }

        System.out.println(fila);
    }
}
