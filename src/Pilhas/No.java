package Pilhas;
public class No<T> {
    public T dado;
    public No proximo;

    public No(T elemento) {
        this.dado = elemento;
        this.proximo = null;
    }
}
