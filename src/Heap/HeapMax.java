package Heap;

public class HeapMax {
    private int[] dados;
    private int contador;

    public HeapMax(int n) {

    }

    public void inserir(int valor) {
        dados[contador] = valor;
        contador++;
        subir(contador-1);
    }

    public void subir(int indice) {
        int indicePai, aux;

        if(indice != 0) {
           indicePai = (indice-1)/2;

           if(dados[indicePai]<dados[indice]) {
               aux = dados[indicePai];
               dados[indicePai] = dados[indice];
               dados[indice] = aux;
               subir(indicePai);
           }
        }
    }

    public void remover() {
        dados[0] = dados[contador-1];
        contador--;
        if(contador>0) {
            descer(0);
        }
    }

    public void descer(int indice) {
        int indiceFilhoEsq, indiceFilhoDir, indiceMax, temp;
        indiceFilhoEsq = 2*indice+1;
        indiceFilhoDir = 2*indice+2;

        if(indiceFilhoDir>= contador) {
            if(indiceFilhoEsq>= contador) {
                return;
            } else {
                indiceMax = indiceFilhoEsq;
            }
        } else {
            if (dados[indiceFilhoEsq] >= dados[indiceFilhoDir]) {
                indiceMax = indiceFilhoEsq;
            } else {
                indiceMax = indiceFilhoDir;
            }
        }

        if(dados[indice] <dados[indiceMax]) {
            temp = dados[indiceMax];
            dados[indiceMax] = dados[indice];
            dados[indice] = temp;
            descer(indiceMax);
        }
    }
}
