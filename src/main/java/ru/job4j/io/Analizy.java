package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        String rsl;
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileWriter(target))) {
            String[] startPosition = new String[2];
            String[] endPosition;
            String input = reader.readLine();
            boolean sleepServ = input.startsWith("400") || input.startsWith("500");
            while (input != null && !input.isEmpty()) {
                if (sleepServ) {
                    startPosition = input.split(" ");
                }
                if (!sleepServ) {
                    endPosition = input.split(" ");
                    rsl = startPosition[1] + "; " + endPosition[1] + System.lineSeparator();
                    writer.write(rsl);
                }
                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            new Analizy().unavailable("./serverLog.txt", "./unavailable.csv");
        }
    }