package ru.job4j.list.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");

        /**добавление в определенном порядке
         * rsl.add(0, "four");*/

        /** Добавление списка
         * List<String> list = new ArrayList<>();
        list.add("four");
        list.add("five");
        rsl.addAll(list);*/

        /** Добавление в определенном порядке списка
        List<String> list = new ArrayList<>();
        list.add("four");
        list.add("five");
        rsl.addAll(2, list);*/

        /** Создание списка
         * List<String> rsl = List.of("one", "two", "three");*/

        /** Один из методов чтения
        for (int i = 0; i < rsl.size(); i++) {
            System.out.println("Текущий элемент: " + rsl.get(i));
        }*/

        /** Использование итератора
        Iterator<String> iterator = rsl.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент: " + iterator.next());
        }*/

        /** иСПОЛЬЗОВАНИЕ ЛИСТЕРАТОРА
        ListIterator<String> iterator = rsl.listIterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент: " + iterator.next());
        }*/

        /** использование листератора для вывода конкретного элемента
        ListIterator<String> iterator = rsl.listIterator(2);
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент: " + iterator.next());
        }*/

        /** Изменение конкретно взятого значения
        rsl.set(1, "two and second");*/

        /** Изменение результатом применения оператора
        rsl.replaceAll(String::toUpperCase); */

        /** Удаление конкретного эллемента по индексу
        rsl.remove(1);*/

        /** Или такое удаление
        rsl.remove("three");*/

        /** Удаление списка элементов
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("three");
        rsl.removeAll(list);*/

        /** Удаление всего кроме выбранных элементов
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("three");
        rsl.retainAll(list);*/

        /** Удаление при выполнении заданного условия
        rsl.removeIf(s -> s.length() <= 3);*/

        /** Метод позволяет выяснить есть ли в списке элемент удовлетворяющий условию
        boolean b = rsl.contains("two");
        System.out.println("Список содержит элемент: " + b);*/

        /** Нахождение элемента по индексу
        int i = rsl.indexOf("two");
        System.out.println("Индекс элемента в списке: " + i);*/

        /** Нахождение индекса по элементу
        int i = rsl.lastIndexOf("one");
        System.out.println("Индекс элемента в списке: " + i);*/

        /** Нахождение размера списка
        int size = rsl.size();
        System.out.println("Размер списка равен: " + size);*/

        /** Нахождение элементов в заданном отрезке
        List<String> list = rsl.subList(1, 2);
        for (String s : list) {
            System.out.println("Текущий элемент: " + s);
        }*/

        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
    }
}




