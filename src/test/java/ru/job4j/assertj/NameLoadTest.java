package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class NameLoadTest {

    @Test
    void checkGetMapWithEmptyInput() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    public void checkParseWithEmptyInput() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    @Test
    public void checkParseWithCorrectInput() {
        NameLoad nameLoad = new NameLoad();
        nameLoad.parse("name1=value1", "name2=value2");
        assertThat(nameLoad.getMap())
                .hasSize(2)
                .containsEntry("name1", "value1")
                .containsEntry("name2", "value2");
    }

    @Test
    public void checkParseWithInvalidInput() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("name1=value1", "=value2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a key");

        assertThatThrownBy(() -> nameLoad.parse("name1=value1", "name2="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a value");

        assertThatThrownBy(() -> nameLoad.parse("name1=value1", "name2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain the symbol");
    }

}