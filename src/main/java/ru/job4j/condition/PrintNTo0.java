package ru.job4j.condition;

public class PrintNTo0 {
    public static void out(int n) {
        for (int index = n - 1; index >= 0; index--) {
            System.out.println(index);
        }
    }
}
