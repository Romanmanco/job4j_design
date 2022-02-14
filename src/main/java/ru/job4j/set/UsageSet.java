package ru.job4j.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsageSet {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        /** Добавление списка
         strings.addAll(List.of("one", "four", "five"));*/

        /** Удаление конкретного элемента
         strings.remove("two");
        System.out.println("Вывод в консоль после удаления...");*/

        /** Удаление заданного списка
         strings.removeAll(List.of("two", "three"));
        System.out.println("Вывод в консоль после удаления...");*/

        /** Удаление всего ктоме заданных элементов
         strings.retainAll(List.of("one"));
        System.out.println("Вывод в консоль после удаления...");*/

        /** Удаление по соответствию условию
         strings.removeIf(s -> s.startsWith("o"));
        System.out.println("Вывод в консоль после удаления...");*/

        /**Дает возможность узнать содержится ли элемент
         boolean b = strings.contains("two");
        System.out.println("Множество содержит элемент: " + b);*/

        /** Использование стрим
         strings.stream()
                .filter(s -> s.length() < 5)
                .forEach(st -> System.out.println("Текущий элемент: " + st));*/

        for (String s : strings) {
            System.out.println("Текущий элемент: " + s);
        }
    }
}

