package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Роман", 1, new GregorianCalendar(2020, Calendar.JUNE, 15, 12, 1, 10));
        User user2 = new User("Роман", 1, new GregorianCalendar(2020, Calendar.JUNE, 15, 12, 1, 10));

        Map<User, Object> userMap = new HashMap<>();
        userMap.put(user1, new Object());
        userMap.put(user2, new Object());
        userMap.forEach((user, o) -> System.out.println("Key: " + user + " Value: " + o));
    }
}
