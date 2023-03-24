package Pilhas;

import java.util.Stack;

public class PilhaEstatica<T> {
    private int proximoVazio;
    private T[] v;

    public PilhaEstatica() {
        this.v = (T[]) new Object[10];
        this.proximoVazio = 0;
    }

    public void push(T elemento) {
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

    public void pop() {
        proximoVazio--;
    }

    public T peek() {
        return v[proximoVazio-1];
    }

    @Override
    public String toString() {
        String print = "[";

        for(int i = 0; i < proximoVazio-1; i++) {
            print+= v[i]+", ";
        }
        print+=v[proximoVazio-1]+"]";

        return print;
    }
}
