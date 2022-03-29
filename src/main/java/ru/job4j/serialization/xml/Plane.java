package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class Plane {

    @XmlAttribute
    private  boolean isFly;

    @XmlAttribute
    private int price;
    private String color;
    private Identificator id;
    private String[] statuses;

    public Plane() {
    }

    public Plane(boolean isFly, int price, String color, Identificator id, String... statuses) {
        this.isFly = isFly;
        this.price = price;
        this.color = color;
        this.id = id;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Plane {"
                + "isFly =" + isFly
                + ", price =" + price
                + ", color =" + color
                + ", identification =" + id
                + ", statuses =" + Arrays.toString(statuses)
                + '}';
    }
}
