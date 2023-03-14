package Listas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        ListaDinamica<ListaTam> listas = new ListaDinamica();
        ListaTam tam = new ListaTam();

        int numCasos = dado.nextInt();
        boolean adicionado;
        listas.add(tam);
        for(int i = 0; i < numCasos;i++) {
            String nome = dado.next();
            adicionado = false;
            for(int j = 0; j < listas.size();j++) {
                if(listas.get(j).add(nome)) {
                    adicionado = true;
                }
            }
            if(adicionado == false) {
                listas.add(new ListaTam());
                listas.get(listas.size()-1).add(nome);
            }
        }
        for(int j = 0; j < listas.size();j++) {
            listas.get(j).show();
        }
    }
}