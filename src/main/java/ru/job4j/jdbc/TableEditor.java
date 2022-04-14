package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;
    private Properties properties;
    private Statement statement;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try (FileInputStream in = new FileInputStream("app.properties")) {
            properties.load(in);
            Class.forName(properties.getProperty("driver"));
            System.out.println("Driver connected");
            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
            System.out.println("Database connection established");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        try {
            statement.execute(String.format(
                    "create table if not exists (%s, %s);", tableName
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable(String tableName) {
        try {
            statement.execute(String.format(
                    "drop table %s;", tableName
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addColumn(String tableName, String columnName, String type) {
        try {
            statement.executeUpdate(String.format(
                    "alter table %s add column %s %s;",
                    tableName, columnName, type
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropColumn(String tableName, String columnName) {
        try {
            statement.executeUpdate(String.format(
                    "alter table %s drop column %s;",
                    tableName, columnName
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        try {
            statement.executeUpdate(String.format(
                    "alter table %s rename column %s to %s;",
                    tableName, columnName, newColumnName
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("app.properties"));
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable("test");
        tableEditor.addColumn("test", "id", "serial");
        tableEditor.addColumn("test", "name", "text");
        tableEditor.renameColumn("test", "name", "username");
        tableEditor.dropColumn("test", "id");
        tableEditor.dropTable("test");
        System.out.println(getTableScheme(tableEditor.connection, "test"));
        tableEditor.close();
    }
}
