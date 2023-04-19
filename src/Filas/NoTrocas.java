package Filas;

public class NoTrocas<T> {
    public T dado;
    public NoTrocas proximo;
    public NoTrocas anterior;
    public int prioridade;
    public int trocado;

    public NoTrocas(T elemento, int prioridade) {
        this.dado = elemento;
        this.prioridade = prioridade;
        this.proximo = null;
        this.anterior = null;
        this.trocado = 0;
    }
}
