package ru.job4j.condition;

public class MultiplicationLoop {
    public static int mult(int a, int b) {
        int multiple = 0;
        for (int index = a; index < b; index++) {
            multiple = a * index * b;
        }
        return multiple;
    }
}
