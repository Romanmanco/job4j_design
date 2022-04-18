package ru.job4j.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 1. У нас появился клиент, который хочет создать базу данных для спамеров.
 * На рынке ему продали диск, в котором находятся txt файлы.
 * Формат данных dump.txt:
 * Petr Arsentev;parsentev@yandex.ru;
 * Ivan Ivanov;iivanov@gmail.com;
 * Клиент просит перевести эти файлы в базу данных PostgreSQL.
 */

public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines()
                    .map(s -> s.split(";"))
                    .forEach(strings -> {
                        if (strings.length != 2 || strings[0].isEmpty() || strings[1].isEmpty()) {
                            throw new IllegalArgumentException("Incorrect incoming data");
                        }
                        users.add(new User(strings[0], strings[1]));
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("url"),
                cfg.getProperty("username"),
                cfg.getProperty("password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users (name, email) values (?, ?);")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("C:/projects/job4j_design/src/main/java/resources/app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "C:/projects/job4j_design/src/main/java/resources/dump.txt");
        db.save(db.load());
    }
}
