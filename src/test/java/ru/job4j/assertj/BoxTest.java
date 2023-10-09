package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isNotEmpty()
                .isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isNotEmpty()
                .isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isNotEmpty()
                .isEqualTo("Cube");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(23, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isNotEmpty()
                .isEqualTo("Unknown object");
    }

    @Test
    void getNumberOfVerticesFourTest() {
        Box box = new Box(4, 10);
        int getNum = box.getNumberOfVertices();
        assertThat(getNum)
                .isNotZero()
                .isEqualTo(4);
    }

    @Test
    void getNumberOfVerticesEightTest() {
        Box box = new Box(8, 10);
        int getNum = box.getNumberOfVertices();
        assertThat(getNum)
                .isNotZero()
                .isEqualTo(8);
    }

    @Test
    void checkThatNumberExistTest() {
        Box box = new Box(8, 10);
        boolean checkedNum = box.isExist();
        assertThat(checkedNum)
                .isNotNull()
                .isTrue();
    }

    @Test
    void checkThatNumberNotExistTest() {
        Box box = new Box(-4, 10);
        boolean checkedNum = box.isExist();
        assertThat(checkedNum)
                .isNotNull()
                .isFalse();
    }

    @Test
    void getAreaWhenZeroTest() {
        Box box = new Box(0, 10);
        double result = box.getArea();
        assertThat(result)
                .isNotNull()
                .isCloseTo(1256d, Percentage.withPercentage(10.0d))
                .isEqualTo(1256.6370614359173d);
    }

    @Test
    void getAreaWhenFourTest() {
        Box box = new Box(4, 15);
        double result = box.getArea();
        assertThat(result)
                .isNotNull()
                .isCloseTo(380d, Percentage.withPercentage(10.0d))
                .isEqualTo(389.71143170299734d);
    }

    @Test
    void getAreaWhenEightTest() {
        Box box = new Box(8, 20);
        double result = box.getArea();
        assertThat(result)
                .isNotNull()
                .isCloseTo(2200d, Percentage.withPercentage(10.0d))
                .isEqualTo(2400.0);
    }

}