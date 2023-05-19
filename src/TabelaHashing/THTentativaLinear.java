package TabelaHashing;

public class THTentativaLinear {
    int size;
    Integer[] tabela;

    public THTentativaLinear(int size) {
        this.size = size;
        this.tabela = new Integer[size];
    }

    public int h(int elemento) {
        return elemento%size;
    }

    public void add(int elemento) {
        if(tabela[h(elemento)] == null) {
            tabela[h(elemento)] = elemento;
        } else {
            //add(elemento)
        }
    }
}
