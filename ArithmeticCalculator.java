package com.example.calculator;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum OperatorType {
    PLUS("+") {
        public double apply(double a, double b) {
            return a+b;
        }},
    MINUS("-") {
        public double apply(double a, double b) {
            return a-b;
        }},
    MULTIPLY("*") {
        public double apply(double a, double b) {
            return a*b;
        }},
    DIVIDE("/"){
        public double apply(double a, double b) {
            if (b==0) throw new ArithmeticException();
            return a / b;
        }
    };

    private final String symbol;

    OperatorType(String symbol){
        this.symbol = symbol;
    };

    public String getSymbol() {
        return this.symbol;
    };

    //추상 메서드-연산
    public abstract double apply(double a, double b);
}

public class ArithmeticCalculator<T> {
    //속성
    private T input1;
    private T input2;
    private T input3;
    private OperatorType operator;
    private List<Double> results = new ArrayList<>();
    private double result;

    //생성자

    //기능
    // 결과 리스트 받아오기
    public List<Double> getResults() {
        return this.results;
    }

    // 입력 연산자에서 OperatorType 찾아 받아오기
    OperatorType findBySymbol(String symbol) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.getSymbol().equals(symbol)) {
                this.operator = operatorType;
            }
        }
        return this.operator;
    };

    // Calculate 메서드
    void calculate(double input1, double input2, OperatorType operator){
        double result = operator.apply(input1, input2);
        System.out.println("계산 결과: " + result);
        this.result = result;
        this.results.add(result);
    }

    // 입력과 결과 비교 스트림, 람다 구현
    public void resultsGreaterThanInput(double input3){
        List<Double> biggerValues = this.results.stream()
                .filter(num -> num>input3)
                .collect(Collectors.toList());
        System.out.println(input3 + "보다 큰 결과: " + biggerValues);
    }
}
