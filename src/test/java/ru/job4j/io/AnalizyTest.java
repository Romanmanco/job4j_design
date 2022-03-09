package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Сорзданы интеграционные тесты для коасса Analizy
 */

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenTwoPeriods() throws IOException {
        Analizy log = new Analizy();
        File target = folder.newFile("unavailable.csv");
        log.unavailable("./data/logOne.csv", target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01;10:59:01;11:01:02;11:02:02;"));
    }

    @Test
    public void whenOnePeriods() throws IOException {
        Analizy log = new Analizy();
        File target = folder.newFile("unavailable.csv");
        log.unavailable("./data/logTwo.csv", target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01;11:02:02;"));
    }
}
