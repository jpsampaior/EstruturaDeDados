package Filas;

public class Main {
    public static void main(String[] args) {
        FilaPrioridadeO<Integer> fila = new FilaPrioridadeO();

        fila.enqueue(1,1);
        System.out.println(fila);
        fila.enqueue(3,3);
        System.out.println(fila);
        fila.enqueue(2,2);
        System.out.println(fila);
    }
}
