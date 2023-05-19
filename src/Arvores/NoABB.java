package Arvores;

public class NoABB {
    public int dado;
    public NoABB esquerdo;
    public NoABB direito;

    public NoABB(int dado) {
        this.dado = dado;
        this.esquerdo = null;
        this.direito = null;
    }
}
