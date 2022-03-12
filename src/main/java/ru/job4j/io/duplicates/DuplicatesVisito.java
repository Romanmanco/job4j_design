package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    Map<FileProperty, List<Path>> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty filePropertys = new FileProperty(attrs.size(), file.getFileName().toString());
        List<Path> list = files.get(filePropertys);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(file);
        files.put(filePropertys, list);
        return super.visitFile(file, attrs);
    }

    public List<Path> showDuplicates() {
        List<Path> duplicate = new ArrayList<>();
        files.values()
                .stream()
                .filter(el -> el.size() > 1)
                .forEach(duplicate::addAll);
        return duplicate;
    }
}
