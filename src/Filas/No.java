package Filas;
public class No<T> {
    public T dado;
    public No proximo;
    public No anterior;

    public No(T elemento) {
        this.dado = elemento;
        this.proximo = null;
        this.anterior = null;
    }
}