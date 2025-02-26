package com.example.calculator;

import java.sql.SQLOutput;
import java.util.Scanner;

import static javax.management.Query.div;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        do {
            count++;
            System.out.println(count + "번째 계산");
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int n1 = scanner.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int n2 = scanner.nextInt();
            System.out.print("연산자를 입력하세요: (+,-,*,/ 가능) ");
            String input = scanner.next();
            char method = input.charAt(0);

            if (method == '+') {
                System.out.println("결과: " + n1 + " + " + n2 + " = " + (n1 + n2));
            } else if (method == '-') {
                System.out.println("결과: " + n1 + " - " + n2 + " = " + (n1 - n2));
            } else if (method == '*') {
                System.out.println("결과: " + n1 + " * " + n2 + " = " + (n1 * n2));
            } else if (method == '/') {
                if (n2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                } else {
                    System.out.println("결과: " + n1 + " / " + n2 + " = " + (n1 / (double) n2));
                }
            } else {
                System.out.println("올바른 값을 입력하세요");
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String retry = scanner.next();
            if (retry.equals("exit")) {
                count = -1;
            }
        } while (count != -1);
        }
    }