package Pilhas;

public class Main {
    public static void main(String[] args) {
        PilhaDinamica<Integer> stack = new PilhaDinamica<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
