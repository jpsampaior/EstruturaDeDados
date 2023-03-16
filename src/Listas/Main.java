package Listas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);

        ListaDinamica<ListaTam> listas = new ListaDinamica();
        listas.add(new ListaTam());

        int numCasos = dado.nextInt();

        for(int i = 0; i < numCasos;i++) {
            String nome = dado.next();
            boolean adicionado = false;

            for(int j = 0; j < listas.size() && adicionado == false; j++) {
                if(!listas.get(j).contais(nome)) {
                    listas.get(j).add(nome);
                    adicionado = true;
                }
            }

            if(adicionado == false) {
                listas.add(new ListaTam());
                listas.get(listas.size()-1).add(nome);
            }
        }

        for(int i = 0; i < listas.size(); i++) {
            listas.get(i).show();
        }




//        if(listas.get(i).contais(nome)) {
//
//        }
//        if(listas.get(i) == null) {
//            listas.add(new ListaTam());
//            listas.get(i).add(nome);
//        } listas.get(i).contais(nome)) {
//            listas.add(new ListaTam().add(nome));
//
//        } else {
//            listas.get(i).add(nome);
//        }




    }
}