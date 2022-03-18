package ru.job4j.condition;

public class AttackRook {
    public static boolean check(String left, String right) {
        char firstLeft = left.charAt(0);
        char secondLeft = left.charAt(1);
        char firstRight = right.charAt(0);
        char secondRight = right.charAt(1);
        boolean rsl = false;
        if (firstLeft == firstRight || secondLeft == secondRight) {
            rsl = true;
        }
        return rsl;
    }
}
