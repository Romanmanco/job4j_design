package ru.job4j.serialization.xml;

public class Identificator {
    private final String id;

    public Identificator(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Identification{"
                + "id='" + id + '\''
                + '}';
    }
}
