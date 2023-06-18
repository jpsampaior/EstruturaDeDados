package Arvores;

public class NoAVL {
    public int dado;
    public NoAVL esquerdo;
    public NoAVL direito;
    public int fatorBalanceamento;

    public NoAVL(int dado) {
        this.dado = dado;
        this.esquerdo = null;
        this.direito = null;
    }
}
