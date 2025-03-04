package com.example.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        Calculator calculator = new Calculator();
        do {
            count++;
            System.out.println(count + "번째 계산");
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int input1 = scanner.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int input2 = scanner.nextInt();
            System.out.print("연산자를 입력하세요: (+,-,*,/ 가능) ");
            String input = scanner.next();
            char method = input.charAt(0);

            calculator.setInput1(input1);
            calculator.setInput2(input2);
            calculator.setMethod(method);

            calculator.calculate();;

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String retry = scanner.next();
            if (retry.equals("exit")) {
                count = -1;
            }
        } while (count != -1);
        ArrayList<Double> results = calculator.getResults();
        System.out.println(results);
        calculator.deleteHistory();
        results.add(20000.0);
        calculator.setResult(results);
        System.out.println(calculator.getResult());
    }
}
