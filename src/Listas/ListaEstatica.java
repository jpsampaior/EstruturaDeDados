package Listas;

public class ListaEstatica<T> {
    private T[] v;
    private int proximoVazio;

    public ListaEstatica() {
        this.v = (T[]) new Object[10];
        this.proximoVazio = 0;
    }

    public void add(T elemento) {
        if(proximoVazio >= v.length) {
            T[] vaux = (T[]) new Object [(int)(v.length*1.5)];

            for(int i = 0; i < v.length;i++) {
                vaux[i] = v[i];
            }
            v = vaux;
        }

        v[proximoVazio] = elemento;
        proximoVazio++;
    }

    public void add(int posicao, T elemento) {
        for(int i=proximoVazio; i>posicao; i--){
            this.v[i] = this.v[i-1];
        }

        this.v[posicao] = elemento;
        this.proximoVazio++;
    }

    public int size() {
        return proximoVazio;
    }

    public void clear() {
        proximoVazio = 0;
    }

    public void remove(int posicao) {
        for(int i = posicao;i<v.length-1;i++) {
            v[i] = v[i+1];
        }
        proximoVazio--;
    }

    public void remove(T elemento) {
        int posicao = indexOf(elemento);

        for(int i = posicao;i<v.length-1;i++) {
            v[i] = v[i+1];
        }
        proximoVazio--;
    }

    public void show() {
        for (int i = 0; i < proximoVazio; i++) {
            System.out.println(v[i] + " ");
        }
    }

    public boolean contains(T elemento) {
        for(int i = 0; i<proximoVazio;i++) {
            if(v[i].equals(elemento)) return true;
        }
        return false;
    }

    public T get(int indice) {
        return v[indice];
    }

    public int indexOf(T elemento) {
        for(int i = 0; i<v.length;i++) {
            if(v[i] == elemento) return i;
        }
        return 0;
    }
}