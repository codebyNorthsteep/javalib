package org.example;

public class Calculator {
    public int add(int a, int b){
        return a+b;
    }

    public int add(int a, int b, int c){
        return a+b+c;
    }

    public int add(int... numbers){
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
