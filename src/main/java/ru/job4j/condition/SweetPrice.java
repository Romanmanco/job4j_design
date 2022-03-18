package ru.job4j.condition;

public class SweetPrice {
    public static void out(int price) {
        int count;
        for (int kg = 1; kg <= 5; kg++) {
            count = kg * price;
            System.out.println(count);
        }
    }
}
