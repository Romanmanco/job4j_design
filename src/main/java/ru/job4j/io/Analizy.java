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
            boolean sleepServ = false;
            while (input != null && !input.isEmpty()) {
                if (!sleepServ && (input.startsWith("400") || input.startsWith("500"))) {
                    startPosition = input.split(" ");
                    sleepServ = true;
                }
                if (sleepServ && (input.startsWith("200") || input.startsWith("300"))) {
                    endPosition = input.split(" ");
                    rsl = startPosition[1] + "; " + endPosition[1] + System.lineSeparator();
                    writer.write(rsl);
                    sleepServ = false;
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