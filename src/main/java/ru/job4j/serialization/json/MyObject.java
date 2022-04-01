package ru.job4j.serialization.json;

import org.json.JSONPropertyIgnore;

import java.util.Arrays;

public class MyObject {
    private final boolean activity;
    private final int cost;
    private final Identificator id;
    private final String[] action;

    public MyObject(boolean activity, int cost, Identificator id, String... action) {
        this.activity = activity;
        this.cost = cost;
        this.id = id;
        this.action = action;
    }

    public boolean isActivity() {
        return activity;
    }

    public int getCost() {
        return cost;
    }

    public Identificator getId() {
        return id;
    }

    public String[] getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "Object{"
                + "activity = " + activity
                + ", cost = " + cost
                + ",id = " + id
                + ", action = " + Arrays.toString(action)
                + '}';
    }
}
