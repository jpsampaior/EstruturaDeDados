package Filas;

public class NoPrioridade<T> {
    public T dado;
    public NoPrioridade proximo;
    public NoPrioridade anterior;
    public int prioridade;

    public NoPrioridade(T elemento, int prioridade) {
        this.dado = elemento;
        this.prioridade = prioridade;
        this.proximo = null;
        this.anterior = null;
    }
}
