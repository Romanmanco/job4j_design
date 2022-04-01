package ru.job4j.serialization.json;

public class Identificator {
    private final String id;

    public Identificator(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id{"
                + "id='" + id + '\''
                + '}';
    }
}
