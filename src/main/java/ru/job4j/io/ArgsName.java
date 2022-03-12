package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        checkEmpty(args.length);
        for (String str : args) {
            checkEquals(str);
            int start = str.indexOf("=");
            checkValue(str, start);
            values.put(str.substring(1, start), str.substring(start + 1));
        }
    }

    private void checkValue(String str, int start) {
        if (str.substring(start + 1).length() == 0) {
            throw new IllegalArgumentException("Value is empty.");
        }
    }

    private void checkEquals(String str) {
        if (!str.contains("=")) {
            throw new IllegalArgumentException("Every parameter should have sign equals.");
        }
    }

    private void checkEmpty(int len) {
        if (len == 0) {
            throw new IllegalArgumentException("Parameter is empty.");
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
