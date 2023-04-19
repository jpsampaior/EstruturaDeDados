package Filas;
import java.util.EmptyStackException;

public class FilaMaiorONumTrocas<T> {
    private NoTrocas<T> primeiro;
    private NoTrocas<T> ultimo;
    private int size;
    private int qtdFixos;

    public FilaMaiorONumTrocas() {
        primeiro = null;
        ultimo = null;
        size = 0;
        qtdFixos = 0;
    }

    public void enqueue(T elemento, int prioridade) {
        NoTrocas<T> novo = new NoTrocas<>(elemento,prioridade);

        if(this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            //Se for mais urgente que o primeiro
            if(novo.prioridade > this.primeiro.prioridade) {
                novo.trocado = 1;
                primeiro.trocado = 1;
                novo.proximo = primeiro;
                this.primeiro.anterior = novo;
                this.primeiro = novo;
                
            } else if (novo.prioridade <= ultimo.prioridade){ //Se for menos/igual urgente que o primeiro
                novo.anterior = this.ultimo;
                ultimo.proximo = novo;
                this.ultimo = novo;
            } else {
                NoTrocas aux = primeiro;

                while(novo.prioridade <= aux.prioridade) {
                    aux = aux.proximo;
                }
                aux.trocado = 1;
                novo.trocado = 1;
                aux.anterior.proximo = novo;
                novo.anterior = aux.anterior;
                novo.proximo = aux;
                aux.anterior = novo;
            }
        }
        size++;
    }

    public T dequeue() {
        NoTrocas<T> saida;
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

    public int getTrocas() {
        if(primeiro.proximo!=null) {
            NoTrocas aux = primeiro;
            while(aux.proximo!=null) {
                if(aux.trocado == 0) {
                    qtdFixos++;
                }
                aux = aux.proximo;
            }
            if(aux.trocado == 0) {
                qtdFixos++;
            }
        } else {
            if(primeiro.trocado == 0) {
                qtdFixos++;
            }
        }

        return this.qtdFixos;
    }

    @Override
    public String toString() {
        String print = "[";
        NoTrocas<T> aux = this.primeiro;

        while (aux.proximo!=null) {
            print+= aux.dado+", ";
            aux = aux.proximo;
        }

        print+= aux.dado+"]";
        return print;
    }
}