package Arvores;

public class ArvoreBinariaDeBusca {
    public NoABB raiz;

    public ArvoreBinariaDeBusca() {
        this.raiz = null;
    }

    public void adicionar(int elemento) {
        if(raiz==null) {
            raiz = new NoABB(elemento);
        } else {
            adicionar(elemento,raiz);
        }
    }

    public void adicionar(int elemento,NoABB raiz) {
        NoABB novo = new NoABB(elemento);

        if(elemento<raiz.dado) {
            if(raiz.esquerdo == null) {
                raiz.esquerdo = novo;
            } else {
                adicionar(elemento, raiz.esquerdo);
            }
        } else if (elemento > raiz.dado) {
            if(raiz.direito == null) {
                raiz.direito = novo;
            } else {
                adicionar(elemento, raiz.direito);
            }
        }

        //verificação do balanceamento
        
    }

    public boolean busca(int elemento) {
        if(raiz==null) {
            return false;
        } else {
            return busca(elemento,raiz);
        }
    }

    private boolean busca(int elemento, NoABB raiz) {
        if(elemento == raiz.dado) {
            return true;
        } else if (elemento < raiz.dado){
            if(raiz.esquerdo == null) {
                return false;
            } else {
                return busca(elemento,raiz.esquerdo);
            }
        } else {
            if(raiz.direito == null) {
                return false;
            } else {
                return busca(elemento,raiz.direito);
            }
        }
    }

     private void exibir(NoABB raiz) {
        //Pre Ordem
        System.out.print(raiz.dado + " ");

        if (raiz.esquerdo != null) {
            exibir(raiz.esquerdo);
        }

        //Em Ordem
         // System.out.print(raiz.dado + " ");

        if (raiz.direito != null) {
            exibir(raiz.direito);
        }

        //Pos Ordem
         // System.out.print(raiz.dado + " ");
    }

    public void exibir() {
        exibir(raiz);
        System.out.println();
    }

    public void remover(int elemento) {
        if(raiz != null) {
            remover(elemento, raiz, null);
        }
    }

    private void remover(int elemento, NoABB raiz, NoABB pai) {
        if(elemento == raiz.dado) {
            if(raiz.esquerdo == null && raiz.direito == null) { //Não tem filhos
                if(raiz == pai.esquerdo) {
                    pai.esquerdo = null;
                } else {
                    pai.direito = null;
                }

            } else if(raiz.esquerdo != null && raiz.direito == null) { //Tem 1 filho (Esquerdo)
                if(raiz == pai.esquerdo) {
                    pai.esquerdo = raiz.esquerdo;
                } else {
                    pai.direito = raiz.esquerdo;
                }

            } else if(raiz.esquerdo == null && raiz.direito != null) { //Tem 1 filho (Direito)
                if(raiz == pai.esquerdo) {
                    pai.esquerdo = raiz.direito;
                } else {
                    pai.direito = raiz.direito;
                }

            } else { //Tem 2 filhos
                raiz.dado = min(raiz.direito);
                remover(raiz.dado,raiz.direito,raiz);
            }

        } else if (elemento < raiz.dado){
            if(raiz.esquerdo != null) {
                remover(elemento, raiz.esquerdo, raiz);
            }

        } else {
            if(raiz.direito != null) {
                remover(elemento, raiz.direito, raiz);
            }
        }
    }

    public int min(NoABB raiz) {
        if(raiz.esquerdo == null) {
            return raiz.dado;
        } else {
            return min(raiz.esquerdo);
        }
    }

    public int max(NoABB raiz) {
        if(raiz.direito == null) {
            return raiz.dado;
        } else {
            return max(raiz.direito);
        }
    }

}