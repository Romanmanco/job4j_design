package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) {
        Config config = new Config("C:/projects/job4j_design/src/main/java/resources/app.properties");
        config.load();
        try {
            Class.forName(config.value("driver"));
            System.out.println("Driver connected");
            String url = config.value("url");
            String username = config.value("username");
            String password = config.value("password");
            try (Connection connect = DriverManager.getConnection(url, username, password)) {
                System.out.println("Database connection established");
                DatabaseMetaData metaData = connect.getMetaData();
                System.out.println(metaData.getUserName());
                System.out.println(metaData.getURL());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}