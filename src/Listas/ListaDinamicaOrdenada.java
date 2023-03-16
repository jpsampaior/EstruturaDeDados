package Listas;

public class ListaDinamicaOrdenada<T extends Comparable<T>> {
    private NoDuplo primeiro;
    private NoDuplo ultimo;
    private int size;

    public ListaDinamicaOrdenada() {
        this.primeiro = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void add(T elemento) {
        NoDuplo<T> novo = new NoDuplo(elemento);

        if(!contais(novo.dado)) {
            if(primeiro == null) {
                this.primeiro = novo;
                this.ultimo = novo;
            } else {
                if(this.primeiro.dado.compareTo(novo.dado) > 0) { //MenorQuePrimeiro
                    novo.proximo = this.primeiro;
                    this.primeiro.anterior = novo;
                    this.primeiro = novo;
                } else if (this.ultimo.dado.compareTo(novo.dado) < 0) { //MaiorQueUltimo
                    novo.anterior = this.ultimo;
                    this.ultimo.proximo = novo;
                    this.ultimo = novo;
                } else { //NoMeio
                    NoDuplo<T> aux = this.primeiro;

                    while (aux.dado.compareTo(novo.dado) < 0) { //MaiorQueAux
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

    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.primeiro = null;
        this.ultimo = null;
        this.size = 0;
    }

    public boolean contais(T elemento) {
        NoDuplo<T> aux = primeiro;

        while (aux != null) {
            if(aux.dado.equals(elemento)) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    public void remove (T elemento) {
        NoDuplo<T> aux = primeiro;
        remove(indexOf(elemento));
    }

    public void remove (int index) {
        NoDuplo<T> aux = primeiro;

        if(index == 0) {
            primeiro = primeiro.proximo;
            primeiro.anterior = null;
        } else {
            for (int i = 0; i < index - 1; i++) {
                aux = aux.proximo;
            }

            if (index >= size) {
                ultimo = aux;
            } else {
                aux.proximo = aux.proximo.proximo;
            }
        }
    }

    public T get(int index) {
        NoDuplo<T> aux = primeiro;

        for (int i = 0; i < index - 1; i++) {
            aux = aux.proximo;
        }

        return aux.dado;
    }

    public int indexOf(T elemento) {
        NoDuplo<T> aux = primeiro;
        int posicao = 0;

        while(aux != null) {
            if(aux.dado.equals(elemento)) {
                return posicao;
            }
            aux=aux.proximo;
            posicao++;
        }

        return -1;
    }

    public void show() {
        NoDuplo<T> aux = primeiro;

        while (aux.proximo != null) {
            System.out.print(aux.dado+" ");
            aux = aux.proximo;
        }
        System.out.println(aux);
    }
}
