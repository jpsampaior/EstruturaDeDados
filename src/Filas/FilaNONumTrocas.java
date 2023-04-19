package Filas;

import java.util.EmptyStackException;

public class FilaNONumTrocas<T> {
    private NoPrioridade<T> primeiro;
    private NoPrioridade<T> ultimo;
    private int size;
    private int trocas;

    public FilaNONumTrocas() {
        primeiro = null;
        ultimo = null;
        size = 0;
        trocas = 0;
    }

    public void enqueue(T elemento, int prioridade) {
        NoPrioridade<T> novo = new NoPrioridade<>(elemento,prioridade);

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

    public void dequeue() {
        NoPrioridade<T> prioritario;

        if(primeiro == null) {
            throw new EmptyStackException();
        } else {
            NoPrioridade aux = this.primeiro;
            prioritario = this.primeiro;

            while(aux != null) {
                if(aux.prioridade < prioritario.prioridade) {
                    prioritario = aux;
                }
                aux = aux.proximo;
            }

            if(primeiro.equals(prioritario)) {
                primeiro = primeiro.proximo;
            } else if (ultimo.equals(prioritario)){
                ultimo = ultimo.anterior;
                ultimo.proximo = null;
            } else {
                prioritario.anterior.proximo = prioritario.proximo;
                prioritario.proximo.anterior = prioritario.anterior;
            }
        }
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String print = "[";
        NoPrioridade<T> aux = this.primeiro;

        while (aux.proximo!=null) {
            print+= aux.dado+", ";
            aux = aux.proximo;
        }

        print+= aux.dado+"]";
        return print;
    }
}
