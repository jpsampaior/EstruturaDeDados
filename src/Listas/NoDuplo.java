package Listas;

public class NoDuplo<T extends Comparable<T>> {
    public T dado;
    public NoDuplo<T> proximo;
    public NoDuplo<T> anterior;

    public NoDuplo(T elemento) {
        this.dado = elemento;
        this.proximo = null;
        this.anterior = null;
    }
}
