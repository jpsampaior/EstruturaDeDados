package Trilhos;

import Pilhas.PilhaDinamica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);

        //Primeira Definição de vagões
        int qtdVagoes = Integer.parseInt(dado.nextLine());

        while (qtdVagoes != 0) {
            boolean verif = true;

            //Definir entrada
            PilhaDinamica<Integer> a = new PilhaDinamica<>();
            for(int i = qtdVagoes; i > 0; i--) {
                a.push(i);
            }

            //Primeiro número da saída
            int saida = Integer.parseInt(dado.next());


            if(saida != 0) {
                PilhaDinamica<Integer> aux = new PilhaDinamica<>();
                aux.push(saida);

                //Resto da sequencia de saida - Invertido
                for(int i = 0; i < qtdVagoes-1; i++) {
                    aux.push(Integer.parseInt(dado.next()));
                }

                //Sequencia de saida correta
                PilhaDinamica<Integer> b = new PilhaDinamica<>();
                while(!aux.empty()) {
                    b.push(aux.peek());
                    aux.pop();
                }
                PilhaDinamica<Integer> estacao = new PilhaDinamica<>();

                //Verificacao
                while(!b.empty() && verif) {

                    //Primeiro caso
                    if(estacao.empty()) {
                        estacao.push(a.peek());
                        a.pop();
                    }
                    //Demais casos
                    else {
                        if(estacao.peek().equals(b.peek())) {
                            estacao.pop();
                            b.pop();
                        } else {
                            if(!a.empty()) {
                                estacao.push(a.peek());
                                a.pop();
                            } else {
                                verif = false;
                            }
                        }
                    }
                }

                if(verif) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                qtdVagoes = Integer.parseInt(dado.next());
                System.out.println();
            }
        }
    }
}