package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("even.txt")) {
            var ln = System.lineSeparator();
            String[] num = {"1" + ln + "6" + ln + "15" + ln + "17"};
            for (int i = 0; i < num.length; i++) {
                out.write(num[i].getBytes());
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] num = text.toString().split(System.lineSeparator());
            for (String number : num) {
                if (Integer.parseInt(number) % 2 == 0) {
                    System.out.println(number);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
