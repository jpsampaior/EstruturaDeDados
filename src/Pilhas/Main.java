package Pilhas;

public class Main {
    public static void main(String[] args) {
        PilhaEstatica<Integer> stack = new PilhaEstatica<>();

        stack.push(1);
        stack.push(2);
        System.out.println(stack);
    }
}
