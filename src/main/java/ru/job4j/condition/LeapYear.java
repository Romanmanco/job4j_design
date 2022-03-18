package ru.job4j.condition;

public class LeapYear {
    public static boolean checkYear(int year) {
        boolean b = false;
        if (year % 400 == 0 || year % 4 == 0) {
            b = true;
        }
        if (year % 100 == 0 && !(year % 400 == 0)) {
            b = false;
        }
        return b;
    }
}
