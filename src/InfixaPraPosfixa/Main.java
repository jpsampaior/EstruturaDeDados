package InfixaPraPosfixa;

import Pilhas.PilhaDinamica;

import java.util.Scanner;

import static java.lang.Character.isLetter;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int qtdCasos;
        char ch;
        String expressao;
        String resultado;
        PilhaDinamica<Character> operadores;

        qtdCasos = dado.nextInt();

        for(int i = 0; i < qtdCasos; i++) {
            operadores = new PilhaDinamica<>();
            expressao = dado.next();
            resultado = "";

            for(int j = 0; j < expressao.length(); j++) {
                ch = expressao.charAt(j);

                if(isLetter(ch) || Character.isDigit(ch)) {
                    resultado+=ch;
                } else if(ch == '(') {
                    operadores.push(ch);
                } else if(ch == ')') {
                    while (operadores.peek() != '(') {
                        resultado+=operadores.peek();
                        operadores.pop();
                    }
                    operadores.pop();
                } else {
                    while(!operadores.empty() && !(operadores.peek()=='(') && (precedencia(ch) <= precedencia(operadores.peek()))) {
                        resultado+=operadores.peek();
                        operadores.pop();
                    }
                    operadores.push(ch);
                }
            }

            while(!operadores.empty()) {
                resultado+=operadores.peek();
                operadores.pop();
            }

            System.out.println(resultado);
        }
    }

    static int precedencia(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        } else if (operador == '^') {
            return 3;
        } else {
            return 0;
        }
    }
}
