package com.example.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    // 1. 속성
    private double result;
    private int input1;
    private int input2;
    private char method;
    private ArrayList<Double> results = new ArrayList<>();

    // 2. 생성자

    // 3. 기능
    // 게터로 결과값 불러오기
    public ArrayList<Double> getResults() {
        return this.results;
    }

    public double getResult() {
        return this.result;
    }

    public int getInput1() {
        return this.input1;
    }

    public int getInput2() {
        return this.input2;
    }

    public char getMethod(char method) {
        return this.method;
    }

    // 세터로 값 설정하기
    void setInput1(int input) {
        this.input1 = input;
    }

    void setInput2(int input) {
        this.input2 = input;
    }

    void setMethod(char method) {
        this.method = method;
    }

    void setResult(ArrayList<Double> results){
        this.results = results;
    }

    // 계산기 메소드 만들기
    void calculate() {
        int value1 = this.input1;
        int value2 = this.input2;
        char method = this.method;

        if (method == '+') {
            this.result = (double) value1 + value2;
            this.results.add(result);
            System.out.println(this.result);
        } else if (method == '-') {
            this.result = (double) value1 - value2;
            this.results.add(result);
            System.out.println(this.result);
        } else if (method == '*') {
            this.result = (double) value1 * value2;
            this.results.add(result);
            System.out.println(this.result);
        } else if (method == '/') {
            if (value2 != 0) {
                this.result = value1 / (double) value2;
                this.results.add(result);
                System.out.println(this.result);
            } else {
                System.out.println("0으로 나눌 수 없습니다.");
            }
        } else {
            System.out.println("올바른 값을 입력하세요");
        }
    }
    public void deleteHistory() {
        if (!results.isEmpty()) {
            double firstResult = results.get(0);
            results.remove(firstResult);
            System.out.println(firstResult + "가 삭제되었습니다.");
        } else {
            System.out.println("계산 히스토리가 없습니다.");
        }
    }
}

