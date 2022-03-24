package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        checkArgs(argsName);
        Path source = Paths.get(argsName.get("path"));
        String[] filter = argsName.get("filter").split(",");
        int[] index = new int[filter.length];
        StringJoiner stringJoiner = new StringJoiner("");
        try (var scanner = new Scanner(source)) {
            while (scanner.hasNext()) {
                String[] columsHead = scanner.nextLine().split(argsName.get("delimiter"));
                for (int i = 0; i < columsHead.length; i++) {
                    String a = columsHead[i];
                    for (int j = 0; j < filter.length; j++) {
                        if (a.equals(filter[j])) {
                            index[j] = i;
                        }
                    }
                }
                for (int j : index) {
                    if (j < index.length - 1) {
                        stringJoiner.add(columsHead[j] + ";");
                    } else {
                        stringJoiner.add(columsHead[j]);
                    }
                }
                stringJoiner.add(System.lineSeparator());
            }
        }
        printRsl(stringJoiner.toString(), argsName.get("out"));
    }

    private static void checkArgs(ArgsName args) {
        Path source = Paths.get(args.get("path"));
        if (!source.toFile().exists() || !source.toFile().isFile()) {
            throw new IllegalArgumentException("Path not valid, or not exist.");
        }
        if (args.get("delimiter") == null) {
            throw new IllegalArgumentException("Delimiter must be defined.");
        }
    }

    private static void printRsl(String rsl, String target) {
        if ("stdout".equals(target)) {
            System.out.println(rsl);
        } else {
            File directory = new File(target);
            if (directory.getParentFile() == null) {
                directory = new File(".\\" + target);
            }
            directory.getParentFile().mkdir();
            try (PrintWriter out = new PrintWriter(new FileWriter(directory.getAbsoluteFile()))) {
                out.write(rsl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName arg = ArgsName.of(args);
        handle(arg);
    }
}
