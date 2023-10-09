package ru.job4j.gc.prof;

import java.util.Random;
import java.util.Scanner;

public class Api {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case (1) -> {
                System.out.println("Сортировка вставкой...");
                RandomArray array = new RandomArray(new Random());
                array.insert(250000);
                new InsertSort().sort(array);
            }
            case (2) -> {
                System.out.println("Пузырьковая сортировка...");
                RandomArray array1 = new RandomArray(new Random());
                array1.insert(250000);
                new BubbleSort().sort(array1);
            }
            case (3) -> {
                System.out.println("Сортировка слиянием...");
                RandomArray array2 = new RandomArray(new Random());
                array2.insert(250000);
                new MergeSort().sort(array2);
            }
            default -> {
                System.out.println("Дефолтная сортировка...");
            }
        }
    }
}
