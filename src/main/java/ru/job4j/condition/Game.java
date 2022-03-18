package ru.job4j.condition;

public class Game {
    public static int checkGame(double percent, int prize, int pay) {
        double sumPrize = percent * prize;
        return sumPrize > pay ? (int) (sumPrize - pay) : 0;
    }
}
