package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileWriter(target))) {
            StringBuilder builder = new StringBuilder();
            String value = null;
            String position;
            while ((position = reader.readLine()) != null) {
                String[] values = position.split(" ");
                if ("400".equals(values[0]) || "500".equals(values[0])) {
                    if (!"400".equals(value) && !"500".equals(value)) {
                        value = values[0];
                        builder.append(values[1]).append(";");
                    }
                } else if ("400".equals(value) || "500".equals(value)) {
                    value = null;
                    builder.append(values[1]).append(";");
                    writer.println(builder);
                    builder.delete(0, builder.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            new Analizy().unavailable("./serverLog.txt", "./unavailable.csv");
        }
    }