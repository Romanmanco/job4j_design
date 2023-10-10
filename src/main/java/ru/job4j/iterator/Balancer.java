package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int numNodes = nodes.size();

        while (source.hasNext()) {
            Integer item = source.next();
            int index = Math.abs(item.hashCode()) % numNodes;
            nodes.get(index).add(item);
        }
    }
}