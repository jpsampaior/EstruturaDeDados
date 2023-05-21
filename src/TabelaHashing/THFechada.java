package TabelaHashing;

import Listas.ListaDinamica;

public class THFechada {
    private ListaDinamica tabela[];

    public THFechada(int n) {
        this.tabela = new ListaDinamica[n];
    }

    public void add(int elemento) {
        int pos = elemento% tabela.length;

        if(tabela[pos] == null) {
            tabela[pos] = new ListaDinamica();
        }

        tabela[pos].add(elemento);
    }

    public void show() {
        for(int i = 0; i < tabela.length;i++) {
            System.out.println("Posição "+i+": ");
            if(tabela[i] != null) {
                tabela[i].show();
            }
        }
    }
}
