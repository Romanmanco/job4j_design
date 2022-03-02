package ru.job4j.io;

import java.io.*;

public class ResultFile {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("result.txt")
                ))) {
            out.println("Hello, world!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
