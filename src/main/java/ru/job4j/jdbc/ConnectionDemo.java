package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Config config = new Config("src/main/app.properties");
        try { Connection connection = DriverManager.getConnection("src/main/app.properties");
            config.load();
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
/** работающий код
//        Class.forName("org.postgresql.Driver");
//        String url = "jdbc:postgresql://localhost:5432/idea_db";
//        String login = "postgres";
//        String password = "password";
//        try (Connection connection = DriverManager.getConnection(url, login, password)) {
//            DatabaseMetaData metaData = connection.getMetaData();
//            System.out.println(metaData.getUserName());
//            System.out.println(metaData.getURL());
//        }
 **/
    }
}