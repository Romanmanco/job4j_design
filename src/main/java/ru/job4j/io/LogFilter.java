package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader objReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = objReader.readLine()) != null) {
                String[] strings = line.split(" ");
                if ("404".equals(strings[strings.length - 2])) {
                    list.add(line);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return list;
    }

    public void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String str : log) {
                out.println(str);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        String resultLog = "resultLog.txt";
        List<String> log = logFilter.filter("log.txt");
        for (String str : log) {
            System.out.println(str);
        }
        logFilter.save(log, resultLog);
    }
}
