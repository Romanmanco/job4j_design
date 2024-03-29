package ru.job4j.io;

import ru.job4j.io.scansystem.Search;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    String directory, exclude, output;

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toFile().getAbsolutePath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validateArgs(String[] args) {
        String errArgs = "Wrong args. Usage: java -jar pack.jar -d=ROOT_DIRECTORY -e=EXCLUDED_FILE_EXTENSION -o=OUTPUT_FILE_NAME";
        if (args.length != 3) {
            throw new IllegalArgumentException(errArgs);
        }
        ArgsName arg = ArgsName.of(args);
        directory = arg.get("d");
        exclude = arg.get("e");
        output = arg.get("o");
        if (directory == null || exclude == null || output == null) {
            throw new IllegalArgumentException(errArgs);
        }
        Path rootDir = Paths.get(directory);
        if (!rootDir.toFile().exists() || !rootDir.toFile().isDirectory()) {
            throw new IllegalArgumentException("Not valid arguments. Root directory is not valid.");
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.validateArgs(args);
        List<Path> listFiles = Search.search(Paths.get(zip.directory), path -> !path.toFile().getName().endsWith(zip.exclude));
        zip.packFiles(listFiles, new File(zip.output));
    }
}
