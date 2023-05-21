package TabelaHashing;

public class THAberta {
    private Integer tabela[];

    public THAberta(int n) {
        this.tabela = new Integer[n];
    }

    public void add(int elemento) {
        int indice = elemento % tabela.length;
        int pos = indice;
        int i = 0;

        while(tabela[pos] != null) {
            i++;
            pos = (indice + 1)%tabela.length;
        }
        tabela[pos] = elemento;
    }

    public void show() {
        for (int i = 0; i < tabela.length; i++) {
            System.out.println(tabela[i] + " ");
        }
        System.out.println();
    }
}
