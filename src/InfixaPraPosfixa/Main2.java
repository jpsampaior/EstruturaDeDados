/*package InfixaPraPosfixa;

import Pilhas.PilhaDinamicaPrintJunto;

import java.util.Scanner;
import static java.lang.Character.isLetter;

public class Main2 {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);


        int qtdCasos = dado.nextInt();

        for(int i = 0; i < qtdCasos; i++) {
            String expressao = dado.next();

            PilhaDinamicaPrintJunto<Character> resultado = new PilhaDinamicaPrintJunto<>();
            PilhaDinamicaPrintJunto<Character> operadores = new PilhaDinamicaPrintJunto<>();
            PilhaDinamicaPrintJunto<Character> divisao = new PilhaDinamicaPrintJunto<>();
            char proximo = ' ';
            for(int j = 0; j < expressao.length(); j++) {
                char ch = expressao.charAt(j);
                if(j != expressao.length()-1) {
                    proximo = expressao.charAt(j+1);
                }

                if(isLetter(ch) || Character.isDigit(ch)) {
                    if(operadores.empty()) {
                        resultado.push(ch);
                    } else {
                        resultado.push(ch);
                        if(proximo=='*' || proximo=='/' && !operadores.empty()) {
                            if(operadores.peek() != '*' && operadores.peek() != '/') {
                                resultado.push(operadores.peek());
                                operadores.pop();
                            }
                        }
                        if(!isLetter(proximo) && !Character.isDigit(proximo)) {
                            resultado.push(operadores.peek());
                            if(operadores.peek() == '*' && operadores.peek() != '/' &&) {

                            }
                            operadores.pop();

                        }
                    }
                } else {
                    if(ch != '(' && ch != ')' && ch != '/') {
                        operadores.push(ch);
                    } else if (ch == '/') {
                        divisao.push(ch);
                    } else if (ch == ')') {
                        if(!divisao.empty()) {
                            resultado.push(divisao.peek());
                            divisao.pop();
                        }
                    }
                }
            }
            if(!operadores.empty()) {
                resultado.push(operadores.peek());
                operadores.pop();
            }
            System.out.println(resultado);
        }
    }
}
*/