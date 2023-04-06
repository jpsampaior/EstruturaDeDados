package Filas;

public class FilaEstatica<T> {
    private T[] v;
    private int inicio;
    private int fim;

    public FilaEstatica() {
        this.v = (T[]) new Object[3];
        this.inicio = 0;
        this.fim = -1;
    }

    public void increaseSize() {
        T[] vaux = v;
        v = (T[]) new Object [(int)(v.length*1.5)];


        if(fim > inicio) {
            for (int i = inicio; i <= fim; i++) {
                v[i] = vaux[i];
            }
        } else {
            int j = 0;

            //Inicio - Lenght
            for(int i = inicio; i < vaux.length; i++) {
                v[j] = vaux[i];
                j++;
            }

            //0 - Fim
            for(int i = 0; i < inicio; i++) {
                vaux[j] = v[i];
                j++;
            }
        }
        fim = vaux.length-1;
        inicio = 0;
    }

    public void dequeue() {
        inicio++;
    }

    public void enqueue(T elemento){
        if(fim+1 == v.length) {
            if (inicio != 0) {
                fim = -1;
                fim++;
                v[fim] = elemento;
            } else {
                increaseSize();
                enqueue(elemento);
            }
        } else if (fim == -1){
            fim++;
            v[fim] = elemento;
        } else  {
            if(fim+1 == inicio) {
                increaseSize();
                enqueue(elemento);
            } else {
                fim++;
                v[fim] = elemento;
            }
        }



        //fim++;
        //v[fim] = elemento;
    }

    public void show() {
        for (int i = 0; i <= fim; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }
}
