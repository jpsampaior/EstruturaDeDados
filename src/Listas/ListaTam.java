package Listas;

public class ListaTam {
    private NoTam primeiro;
    private NoTam ultimo;
    private int size;

    public ListaTam() {
        this.primeiro = null;
        this.ultimo = null;
        this.size = 0;
    }

    public boolean add(String elemento) {
        NoTam novo = new NoTam(elemento);

        if(!contais(elemento)) {
            if(primeiro == null) {
                this.primeiro = novo;
                this.ultimo = novo;
            } else {
                if(novo.dado.length() < primeiro.dado.length()) { //MenorQuePrimeiro
                    novo.proximo = this.primeiro;
                    this.primeiro.anterior = novo;
                    this.primeiro = novo;
                } else if (novo.dado.length() > ultimo.dado.length()) { //MaiorQueUltimo
                    novo.anterior = this.ultimo;
                    this.ultimo.proximo = novo;
                    this.ultimo = novo;
                } else { //NoMeio
                    NoTam aux = this.primeiro;

                    while (novo.dado.length() > aux.dado.length()) { //MaiorQueAux
                        aux = aux.proximo;
                    }

                    aux.anterior.proximo = novo;
                    novo.anterior = aux.anterior;
                    novo.proximo = aux;
                    aux.anterior = novo;
                }
            }
            size++;

            return true;
        }

        else {
            return false;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean contais(String elemento) {
        NoTam aux = primeiro;

        while (aux != null) {
            if(aux.dado.length() == elemento.length()) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }


    public void show() {
        NoTam aux = primeiro;

        while (aux != null && aux != ultimo) {
            System.out.print(aux.dado+", ");
            aux = aux.proximo;
        }
        System.out.print(ultimo.dado);
        System.out.println();
    }
}
