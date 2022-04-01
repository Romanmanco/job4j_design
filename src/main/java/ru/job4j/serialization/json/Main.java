package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JSONObject jsonId = new JSONObject("{\"id\":\"123456\"}");

        List<String> list = new ArrayList<>();
        list.add("Shopping");
        list.add("Watching cinema");
        JSONArray jsonAction = new JSONArray(list);

        final MyObject object = new MyObject(true, 1500, new Identificator("123"),
                "Working", "Chilling");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("activity", object.isActivity());
        jsonObject.put("cost", object.getCost());
        jsonObject.put("id", jsonId);
        jsonObject.put("action", jsonAction);

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(object).toString());

        /** Преобразование объекта в json, без библиотеки org.json
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
         **/
    }
}
