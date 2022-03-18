package ru.job4j.condition;

public class WeeklySalary {
    public static int calculate(int[] hours) {
        int salary = 0;
        int norm = 8;

        for (int i = 0; i < hours.length; i++) {
            if (hours[i] <= norm && hours[i] > 0) {
                salary = salary + hours[i] * 10;
            }
            if (hours[i] > norm && hours[i] > 0) {
                salary = ((hours[i] - norm) * 15) + 80 + salary;
            }
        }
        for (int j = 5; j < hours.length; j++) {
            if (hours[j] <= norm && hours[j] > 0) {
                salary = salary + hours[j] * 20;
            }
            if (hours[j] > norm && hours[j] > 0) {
                salary = ((hours[j] - norm) * 30) + salary - 20;
            }
        }
        return salary;
    }
}
