package ru.job4j.serialization.xml;

import java.util.Arrays;

public class Plane {

    private final boolean isFly;
    private final int price;
    private final String color;
    private final Identificator id;
    private final String[] statuses;

    public Plane(boolean isFly, int price, String color, Identificator id, String... statuses) {
        this.isFly = isFly;
        this.price = price;
        this.color = color;
        this.id = id;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Plane {"
                + "isFly =" + isFly
                + ", price =" + price
                + ", color =" + color
                + ", identification =" + id
                + ", statuses =" + Arrays.toString(statuses)
                + '}';
    }
}
