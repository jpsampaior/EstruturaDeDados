package Pilhas;

public class PilhaDinamica<T> {
    private No<T> topo;

    public void push(T elemento) {
        No<T> novo = new No<>(elemento);

        if(this.topo == null) {
            this.topo = novo;
        } else {
            No<T> aux = this.topo;
            while (aux.proximo!=null) {
                aux = aux.proximo;
            }
            aux.proximo=novo;
        }
    }

    public void pop() {
        if(this.topo == null) {
            this.topo = null;
        } else {
            No<T> aux = this.topo;
            while (aux.proximo.proximo!=null) {
                aux = aux.proximo;
            }
            aux.proximo=null;
        }
    }

    public T peek() {
        No<T> aux = this.topo;
        while (aux.proximo!=null) {
            aux = aux.proximo;
        }
        return aux.dado;
    }

    @Override
    public String toString() {
        String print = "[";

        No<T> aux = this.topo;
        while (aux.proximo!=null) {
            print+= aux.dado+", ";
            aux = aux.proximo;
        }
        print+= aux.dado+"]";

        return print;
    }

}
