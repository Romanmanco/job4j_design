package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Roman"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithCommentsAndEmptyStrings() {
        String path = "./data/pair_with_comments_and_empty_strings.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("country"), is("Russia"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutFirstValue() {
        String path = "./data/pair_without_first_value.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutSymbol() {
        String path = "./data/pair_without_symbol.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutSecondValue() {
        String path = "./data/pair_without_second_value.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key2"), is(Matchers.nullValue()));
    }
}
