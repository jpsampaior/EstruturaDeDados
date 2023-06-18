package Arvores;

public class ArvoreAVL {
    public NoAVL raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    private NoAVL rotacaoSimplesEsquerda(NoAVL no) {
        NoAVL aux = no.direito;

        if(aux.esquerdo != null) {
            no.direito = aux.esquerdo;
            aux.esquerdo = no;
        } else {
            aux.esquerdo = no;
            no.direito = null;
        }

        //Atualizar Fator

        return no;
    }

    private NoAVL rotacaoSimplesDireita(NoAVL no) {
        NoAVL aux = no.esquerdo;

        if(aux.direito != null) {
            no.esquerdo = aux.direito;
            aux.direito = no;
        } else {
            aux.direito = no;
            no.esquerdo = null;
        }

        //Atualizar Fator

        return no;
    }

    private NoAVL rotacaoDuplaEsquerda(NoAVL no) {
        no.direito = rotacaoSimplesDireita(no.direito);
        return rotacaoSimplesEsquerda(no);
    }

    private NoAVL rotacaoDuplaDireita(NoAVL no) {
        no.esquerdo = rotacaoSimplesEsquerda(no.esquerdo);
        return rotacaoSimplesDireita(no);
    }

    private void definirFator(NoAVL no) {
        no.fatorBalanceamento = alturaEsquerdo(no) - alturaDireito(no);
    }

    private int altura(NoAVL no, int esquerdo, int direito){
        if(no.esquerdo != null) {
            esquerdo = altura(no.esquerdo, ++esquerdo, direito);
        }
        if(no.direito != null) {
            direito = altura(no.direito, esquerdo, ++direito);
        }
        return Math.max(esquerdo, direito);
    }

    private int altura(NoAVL no) {
        int esquerdo;
        int direito;

        if(no != null) {
            if(no.esquerdo != null && no.direito != null) {
                esquerdo = altura(no.esquerdo, 1, 1);
                direito = altura(no.direito, 1, 1);
            } else if (no.esquerdo != null) {
                esquerdo = altura(no.esquerdo, 1, 0);
                direito = 0;
            } else if (no.direito != null) {
                esquerdo = 0;
                direito = altura(no.direito, 0, 1);
            } else {
                esquerdo = 0;
                direito = 0;
            }
            System.out.println("");
            return Math.max(esquerdo,direito);
        }

        return -1;
    }

    private int altura() {
        return altura(raiz);
    }

    private int alturaEsquerdo(NoAVL no) {
        return altura(no.esquerdo) + 1;
    }

    private int alturaDireito(NoAVL no) {
        return altura(no.direito) + 1;
    }

    private int alturaEsquerdo() {
        return alturaEsquerdo(raiz);
    }

    private int alturaDireito() {
        return alturaDireito(raiz);
    }

    public void adicionar(int elemento) {
        if(raiz==null) {
            raiz = new NoAVL(elemento);
        } else {
            adicionar(elemento,raiz);
            //Flag
        }
    }

    public void adicionar(int elemento, NoAVL raiz) {
        NoAVL novo = new NoAVL(elemento);

        if(elemento<raiz.dado) {
            if(raiz.esquerdo == null) {
                raiz.esquerdo = novo;
                raiz.fatorBalanceamento++;


            } else {
                adicionar(elemento, raiz.esquerdo);
                if(raiz.esquerdo.fatorBalanceamento != 0) {
                    raiz.fatorBalanceamento++;
                }
            }
        } else if (elemento > raiz.dado) {
            if(raiz.direito == null) {
                raiz.direito = novo;
            } else {
                adicionar(elemento, raiz.direito);
                if(raiz.direito.fatorBalanceamento != 0) {
                    raiz.fatorBalanceamento++;
                }
            }
        }

        if(raiz.fatorBalanceamento >= 2) {
            if (raiz.esquerdo.fatorBalanceamento >= 0) {
               raiz = rotacaoSimplesDireita(raiz);
            } else {
                raiz = rotacaoDuplaDireita(raiz);
            }
        } else if(raiz.fatorBalanceamento <= -2) {
            if (raiz.esquerdo.fatorBalanceamento <= 0) {
                raiz = rotacaoSimplesEsquerda(raiz);
            } else {
                raiz = rotacaoDuplaEsquerda(raiz);
            }
        }


        //verificação do balanceamento

    }

    public void verificarBalanceamento() {
        
    }

    public boolean busca(int elemento) {
        if(raiz==null) {
            return false;
        } else {
            return busca(elemento,raiz);
        }
    }

    private boolean busca(int elemento, NoAVL raiz) {
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

    private void exibir(NoAVL raiz) {
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

    private void remover(int elemento, NoAVL raiz, NoAVL pai) {
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

    public int min(NoAVL raiz) {
        if(raiz.esquerdo == null) {
            return raiz.dado;
        } else {
            return min(raiz.esquerdo);
        }
    }

    public int max(NoAVL raiz) {
        if(raiz.direito == null) {
            return raiz.dado;
        } else {
            return max(raiz.direito);
        }
    }
}
