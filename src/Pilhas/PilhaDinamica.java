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
        No<T> aux = topo;
        if(aux.proximo == null) {
            topo = null;
        } else {
            while(aux.proximo.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = null;
        }
    }

    public T peek() {
        No<T> aux = this.topo;

        while (aux.proximo!=null) {
            aux = aux.proximo;
        }
        return aux.dado;
    }

    public boolean empty() {
        if(topo == null) {
            return true;
        } else return false;
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