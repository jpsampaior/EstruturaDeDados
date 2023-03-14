package Listas;

public class ListaDinamica<T> {
    private No primeiro;
    private No ultimo;
    private int size;

    public ListaDinamica() {
        this.primeiro = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void add(T elemento) {
        No<T> novo = new No(elemento);

        if(primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            this.ultimo.proximo = novo;
            this.ultimo = novo;
        }
        size++;
    }

    public void add(int posicao, T elemento) {
        No<T> novo = new No(elemento);
        No<T> aux = primeiro;

        if(posicao==0) {
            novo.proximo = primeiro;
            primeiro = novo;
        } else if (posicao>=size) {
            ultimo.proximo = novo;
            ultimo = novo;
        } else {
            for(int i = 0; i<posicao-1;i++) {
                aux = aux.proximo;
            }
            aux.proximo.proximo = novo.proximo;
            aux.proximo = novo;
        }

        size++;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.primeiro = null;
        this.ultimo = null;
        this.size = 0;
    }

    public boolean contains(T elemento) {
        No<T> aux = primeiro;

        while (aux != null) {
            if(aux.dado.equals(elemento)) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    public void remove (T elemento) {
        No<T> aux = primeiro;
        remove(indexOf(elemento));

        /*int posicao = indexOf(elemento);

        if(posicao == 0) {
            primeiro = primeiro.proximo;
        } else {
            for (int i = 0; i < posicao - 1; i++) {
                aux = aux.proximo;
            }

            if (posicao >= size) {
                ultimo = aux;
            } else {
                aux.proximo = aux.proximo.proximo;
            }
        }*/
    }

    public void remove (int index) {
        No<T> aux = primeiro;

        if(index == 0) {
            primeiro = primeiro.proximo;
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
        No<T> aux = primeiro;

        for (int i = 0; i < index - 1; i++) {
            aux = aux.proximo;
        }

        return aux.dado;
    }

    public int indexOf(T elemento) {
        No aux = primeiro;
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
        No<T> aux = primeiro;

        while (aux != null) {
            System.out.print(aux.dado+" ");
            aux = aux.proximo;
        }
        System.out.println();
    }


}
