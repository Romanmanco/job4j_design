package ru.job4j.condition;

public class BonusCupCoffee {
    public static int countCup(int count, int n) {
        int bonus = count / n;
        return count > n ? (int) (count + Math.floor(bonus)) : n;
    }
}
