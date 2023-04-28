package Filas;

import java.util.EmptyStackException;

public class FilaDesistencia<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int size = 0;

    public FilaDesistencia() {
        primeiro = null;
        ultimo = null;
        size = 0;
    }

    public void enqueue(T elemento) {
        No<T> novo = new No<>(elemento);

        if(this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            this.ultimo.proximo = novo;
            novo.anterior = this.ultimo;
            this.ultimo = novo;
        }
        size++;
    }

    public T dequeue() {
        No<T> saida;
        if(primeiro == null) {
            throw new EmptyStackException();
        } else {
            saida = primeiro;

            if(primeiro.equals(ultimo)) {
                primeiro = null;
                ultimo = null;
            } else {
                primeiro = primeiro.proximo;
            }
        }
        size--;
        return saida.dado;
    }

    public T dequeue(T dado) {
        No<T> saida;

        if(primeiro == null) {
            throw new EmptyStackException();
        } else {
            No aux = this.primeiro;

            while(!aux.dado.equals(dado)) {
                aux = aux.proximo;
            }

            saida = aux;

            if(aux.equals(primeiro)) {
                primeiro = primeiro.proximo;
            } else if(aux.equals(ultimo)) {
                ultimo = ultimo.anterior;
                ultimo.proximo = null;
            } else {
                aux.anterior.proximo = aux.proximo;
                aux.proximo.anterior = aux.anterior;
            }
        }

        size--;
        return saida.dado;
    }

    public T peek() {
        if(primeiro == null) {
            throw new EmptyStackException();
        }
        return primeiro.dado;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String print = "";
        No<T> aux = this.primeiro;

        while (aux.proximo!=null) {
            print+= aux.dado+" ";
            aux = aux.proximo;
        }

        print+= aux.dado;
        return print;
    }
}