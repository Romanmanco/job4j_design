package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0, changed = 0, deleted = 0;
        Map<Integer, String> map = new HashMap<>();
        for (User user : previous) {
            map.put(user.getId(), user.getName());
        }
        for (User user : current) {
            String value = map.put(user.getId(), user.getName());
            if (value == null) {
                added++;
            } else if (!user.getName().equals(value)) {
                changed++;
            }
        }
        deleted = Math.abs(map.size() - current.size());
        return new Info(added, changed, deleted);
    }


}
