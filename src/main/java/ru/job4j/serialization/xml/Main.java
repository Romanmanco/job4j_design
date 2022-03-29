package ru.job4j.serialization.xml;

public class Main {
    public static void main(String[] args) {
        final Plane plane = new Plane(true, 1000, "yellow",
                new Identificator("123"), "Flying", "chilling");
    }
}
