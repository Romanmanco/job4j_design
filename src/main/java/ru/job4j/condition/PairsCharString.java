package ru.job4j.condition;

public class PairsCharString {
    public static boolean check(String l, String r) {
        return l.isEmpty() && r.isEmpty() || l.charAt(0) == r.charAt(r.length() - 1);
    }
}
