package ru.job4j.io.scansystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Not valid arguments. Usage java -jar search.jar ROOT_FOLDER FILE_EXTENSION.");
        }
        Path start = Paths.get(args[0]);
        if (!start.toFile().exists() || !start.toFile().isDirectory()) {
            throw new IllegalArgumentException("Not valid arguments. Root folder is not valid.");
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("Not valid arguments. File extension is not valid.");
        }
        search(start, p -> p.toFile()
                .getName()
                .endsWith(args[1]))
                .forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
