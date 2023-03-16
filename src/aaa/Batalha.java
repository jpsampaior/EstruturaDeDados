package aaa;

public class Batalha {
    Treinador treinador1;
    Treinador treinador2;

    public String batalha() {
        if(treinador1.getValorGolpeTotal() > treinador1.getValorGolpeTotal()) {
            return "Treinador1";
        } else if(treinador1.getValorGolpeTotal() < treinador1.getValorGolpeTotal()) {
            return "Treinador2";
        } else {
            return "Empate";
        }
    }

    public Treinador getTreinador1() {
        return treinador1;
    }

    public void setTreinador1(Treinador treinador1) {
        this.treinador1 = treinador1;
    }

    public Treinador getTreinador2() {
        return treinador2;
    }

    public void setTreinador2(Treinador treinador2) {
        this.treinador2 = treinador2;
    }
}
