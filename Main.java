package com.example.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요 ");
            double input1 = sc.nextDouble();

            System.out.print("두 번째 숫자를 입력하세요 ");
            double input2 = sc.nextDouble();

            System.out.print("연산 기호를 입력하세요 ");
            String symbol = sc.next();

            OperatorType operator = arithmeticCalculator.findBySymbol(symbol);
            try {
                arithmeticCalculator.calculate(input1, input2, operator);
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다.");
            }

            System.out.print("계속하시겠습니까? (exit 입력 시 종료) ");
            if (sc.next().equals("exit")){
                break;
            }
        }
        System.out.print("결과값을 비교하시겠습니까? (yes 입력 시 실행)");
        String answer = sc.next();
        if (answer.equals("yes")) {
            System.out.print("비교하고 싶은 값을 입력하세요 ");
            double input3 = sc.nextDouble();
            arithmeticCalculator.resultsGreaterThanInput(input3);
        }
    }
}
