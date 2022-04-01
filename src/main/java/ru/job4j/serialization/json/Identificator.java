package ru.job4j.serialization.json;

public class Identificator {
    private final String id;

    public Identificator(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Id{"
                + "id='" + id + '\''
                + '}';
    }
}
