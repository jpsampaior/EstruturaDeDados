package BalancoDeParentesesI;

import Pilhas.PilhaDinamica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);


        while(dado.hasNext()) {
            PilhaDinamica<Character> stack = new PilhaDinamica<>();
            String expression = dado.nextLine();
            boolean tf = true;
            for(int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if(ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if(stack.empty()) {
                        tf = false;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(!stack.empty() || !tf) {
                System.out.println("incorrect");
            } else {
                System.out.println("correct");
            }
        }
    }
}
