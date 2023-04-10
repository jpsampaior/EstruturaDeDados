package Filas;
import java.util.EmptyStackException;

public class FilaPrioridadeO<T> {
    private NoPrioridade<T> primeiro;
    private NoPrioridade<T> ultimo;
    private int size = 0;

    public FilaPrioridadeO() {
        primeiro = null;
        ultimo = null;
        size = 0;
    }

    public void enqueue(T elemento, int prioridade) {
        NoPrioridade<T> novo = new NoPrioridade<>(elemento,prioridade);

        if(this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            //Se for mais urgente que o primeiro
            if(novo.prioridade < this.primeiro.prioridade) {
                this.primeiro.anterior = novo;
                this.primeiro = novo;
            } else if (novo.prioridade >= ultimo.prioridade){ //Se for menos/igual urgente que o primeiro
                novo.anterior = this.ultimo;
                ultimo.proximo = novo;
                this.ultimo = novo;
            } else {
                NoPrioridade aux = primeiro;

                while(novo.prioridade >= aux.prioridade) {
                    aux = aux.proximo;
                }

                aux.anterior.proximo = novo;
                novo.anterior = aux.anterior;
                novo.proximo = aux;
                aux.anterior = novo;
            }
        }
        size++;
    }

    public T dequeue() {
        NoPrioridade<T> saida;
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