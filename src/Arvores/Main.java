package Arvores;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaDeBusca arvoreBinariaDeBusca = new ArvoreBinariaDeBusca();

        arvoreBinariaDeBusca.adicionar(7);
        arvoreBinariaDeBusca.adicionar(5);
        arvoreBinariaDeBusca.adicionar(12);
        arvoreBinariaDeBusca.adicionar(2);
        arvoreBinariaDeBusca.adicionar(6);
        arvoreBinariaDeBusca.adicionar(9);
        arvoreBinariaDeBusca.adicionar(21);
        arvoreBinariaDeBusca.adicionar(19);
        arvoreBinariaDeBusca.adicionar(25);
        arvoreBinariaDeBusca.exibir();
        arvoreBinariaDeBusca.remover(12);
        arvoreBinariaDeBusca.exibir();
    }
}
