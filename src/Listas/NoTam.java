package Listas;

public class NoTam {
    public String dado;
    public NoTam proximo;
    public NoTam anterior;

    public NoTam(String elemento) {
        this.dado = elemento;
        this.proximo = null;
        this.anterior = null;
    }
}
