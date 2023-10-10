package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int numNodes = nodes.size();
        int index = 0;

        while (source.hasNext()) {
            Integer item = source.next();
            nodes.get(index++).add(item);

            if (index >= numNodes) {
                index = 0;
            }
        }
    }
}