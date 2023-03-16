package ListaDeCompras;

import Listas.ListaDinamicaOrdenada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDinamicaOrdenada<String> ordenada = new ListaDinamicaOrdenada<>();
        Scanner dado = new Scanner(System.in);

        int numCasos = Integer.parseInt(dado.nextLine());
        for (int i = 0; i < numCasos; i++) {
            String[] compras = dado.nextLine().split(" ");
            for(int j = 0; j < compras.length;j++) {
                ordenada.add(compras[j]);
            }
            ordenada.show();
            ordenada.clear();
        }

    }
}

