package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final MyObject object = new MyObject(true, 1000, new Identificator("123"),
                "Working", "Chilling");

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(object));

        final String objJson =
                "{"
                        + "\"activity\": true,"
                        + "\"cost\": 2500,"
                        + "\"id\":"
                        + "{"
                        + "\"id\":\"12345\""
                        + "},"
                        + "\"action\":"
                        + "[\"Shopping\",\"Watching cinema\"]"
                        + "}";
        final MyObject objMod = gson.fromJson(objJson, MyObject.class);
        System.out.println(objMod);
    }
}
