package Filas;

public class Main {
    public static void main(String[] args) {
        FilaEstatica<Integer> fila = new FilaEstatica();

        fila.enqueue(1);
        fila.show();
        fila.enqueue(2);
        fila.show();
        fila.enqueue(3);
        fila.show();
        fila.enqueue(4);
        fila.show();
    }
}
