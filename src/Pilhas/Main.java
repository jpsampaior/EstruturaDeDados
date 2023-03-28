package Pilhas;

public class Main {
    public static void main(String[] args) {
        PilhaDinamica<Integer> stack = new PilhaDinamica<>();

        stack.push(1);
        stack.push(1);
        stack.pop();
        System.out.println(stack.empty());
    }
}
