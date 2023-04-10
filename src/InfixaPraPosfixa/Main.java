/*package InfixaPraPosfixa;

import Pilhas.PilhaDinamicaPrintJunto;

import java.util.Scanner;

import static java.lang.Character.isLetter;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);


        int qtdCasos = dado.nextInt();

        for(int i = 0; i < qtdCasos; i++) {
            PilhaDinamicaPrintJunto<Character> resultado = new PilhaDinamicaPrintJunto<>();
            PilhaDinamicaPrintJunto<Character> operadores = new PilhaDinamicaPrintJunto<>();
            String expressao = dado.next();

            for(int j = 0; j < expressao.length(); j++) {
                char ch = expressao.charAt(j);

                if (!isLetter(ch) && Character.isDigit(ch)) {
                    while (!resultado.empty() && hasHigherPrecedence(ch, resultado.peek())) {

                        char connective = resultado.peek();
                        resultado.pop();

                        resultado.push();
                        boolean operand2 = operands.pop();
                        boolean operand1 = operands.pop();
                        boolean result = applyConnective(connective, operand1, operand2);

                        operands.push(result);
                    }
                    resultado.push(ch);
                }
            }

        }
    }

    public static boolean hasHigherPrecedence(char connective1, char connective2) {
        int priority1 = 0;
        int priority2 = 0;

        //Quanto menor o número, mais prioridade ele tem
        for(char ch = connective1, i = 0;  i<2 ;ch = connective2, i++) {
            switch (ch) {
                case '*':
                    if (i == 0) priority1 = 1;
                    else priority2 = 1;
                case '/':
                    if (i == 0) priority1 = 1;
                    else priority2 = 1;
                case '-':
                    if (i == 0) priority1 = 3;
                    else priority2 = 3;
                case '+':
                    if (i == 0) priority1 = 3;
                    else priority2 = 3;
            }
        }

        if(priority1>priority2) {
            return true;
        }
        else {
            return false;
        }
    }
}*/
